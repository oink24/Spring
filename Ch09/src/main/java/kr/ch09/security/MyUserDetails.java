package kr.ch09.security;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class MyUserDetails implements UserDetails{
	private static final long serialVersionUID = -5532680704133363159L;
	
	// 속성 추가
	private String uid;
	private String pass;
	private String name;
	private int age;
	private String hp;
	private String role; // User, Manager, Admin
	private LocalDateTime regDate;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { // 권한을 리턴해주는 메서드(권한이 여러개 있는 유저가 있기때문에 리스트반환)
		
		// 계정이 갖는 권한 목록
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		
		return authorities; // 권한목록을 리스트로 리턴
	}

	@Override
	public String getPassword() { // 비밀번호를 리턴하는 Getter
		
		// 계정이 갖는 비밀번호
		return pass;
	}

	@Override
	public String getUsername() { // 시큐리티에서 유저네임은 사용자이름을 의미하는게 아니라 Id를 의미
		
		// 계정이 갖는 아이디
		return uid;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		// 계정 만료 여부(true:만료X, false:만료), false=해당계정 로그인 불가
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		// 계정 잠김 여부(true:안잠김, false:잠김)
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		// 계정 비밀번호 만료 여부(true:만료X, false:만료), 비밀번호 변경하게끔
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		// 계정 활성화 여부(true:활성화, false:비활성화)
		return true;
	}
}
