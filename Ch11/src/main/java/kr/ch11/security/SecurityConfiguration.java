package kr.ch11.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import kr.ch11.jwt.JwtProvider;

@Configuration
public class SecurityConfiguration {
	
	@Autowired
	private SecurityUserService service;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.csrf(CsrfConfigurer::disable) // 사이트 위변조 방지 비활성, 메서드 참조 연산자로 람다식 간결표현
			.httpBasic(HttpBasicConfigurer::disable) // 기본 HTTP 인증방식 비활성
			.formLogin(FormLoginConfigurer::disable) // 토큰 방식으로 로그인 처리하기때문에 폼방식 비활성
													// 사용자로부터 폼 데이터를 받는 게 아니라 제이슨으로 받아야함 따라서 해제
			.sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 토큰기반 인증 방식이기때문에 세션 사용안함
			.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests // 인가 권한 설정
									.requestMatchers("/admin/**").hasAuthority("ADMIN")
									.requestMatchers("/manager/**").hasAnyAuthority("ADMIN", "MANAGER")
									.requestMatchers("/user/**").permitAll()
									.anyRequest().permitAll());
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
}
