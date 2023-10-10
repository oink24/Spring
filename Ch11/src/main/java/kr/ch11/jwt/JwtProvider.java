package kr.ch11.jwt;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import kr.ch11.entity.UserEntity;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Component
public class JwtProvider {
	
	/*
	 * 반드시 jjwt 라이브러리를 0.11.5 버전으로 할 것 (0.12 버전 X)
	 */
	
	private String issuer;
	private SecretKey secretKey;
	
	public JwtProvider(@Value("${jwt.issuer}") String issuer, // 설정파일에서 설정한 것들이 들어옴
					   @Value("${jwt.secret}") String secret) {
		
		this.issuer = issuer;
		this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
	}
	
	public String createToken(UserEntity user, int days) { // 토큰 두개 생성 acces, rpresh
		
		// 발급일, 완료일 생성
		Date issuedDate = new Date();
		Date expireDate = new Date(issuedDate.getTime() + Duration.ofDays(days).toMillis());
		
		// 클레임 생성
		Claims claims = Jwts.claims();
		claims.put("uid", user.getUid()); // 인증 시
		claims.put("role", user.getRole()); // 인가 시
		
		// 토큰 생성
		String token = Jwts.builder() // 피피티의 알록달록부분 나옴
						   .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
						   .setIssuer(issuer)
						   .setIssuedAt(issuedDate)
						   .setExpiration(expireDate)
						   .addClaims(claims)
						   .signWith(secretKey, SignatureAlgorithm.HS256)
						   .compact();
		return token;
	}
	
	public Authentication getAuthentication(String token) { // 토큰을 받아서 시큐리티 객체를 만들어야함
		
		Claims claims = getClaims(token);
		String uid  = (String) claims.get("uid");
		String role = (String) claims.get("role");
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		
		User principal = new User(uid, "", authorities);
		
		return new UsernamePasswordAuthenticationToken(principal, token, authorities);
	}
	
	public boolean validateToken(String token) { // 토큰 검사메서드, 위변조 여부 체크
		
		try {
			Jwts.parserBuilder()
				.setSigningKey(secretKey)
				.build()
				.parseClaimsJwt(token);
			
			return true;
			
		}catch(SecurityException | MalformedJwtException e) {
			log.debug("잘못된 JWT 서명입니다.");
		}catch(ExpiredJwtException e) {
			log.debug("만료된 JWT 서명입니다.");
		}catch(UnsupportedJwtException e) {
			log.debug("지원되지 않는 JWT 서명입니다.");
		}catch(IllegalArgumentException e) {
			log.debug("JWT 토큰이 잘못되었습니다.");
		}
		
		return false;
	}
	
	public Claims getClaims(String token) { // 토큰에 들어있는 정보, JWT에 대한 정보
		return Jwts.parserBuilder()
				   .setSigningKey(secretKey)
				   .build()
				   .parseClaimsJwt(token)
				   .getBody();
	}
}
