package kr.ch12.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "User")
public class UserEntity implements OAuth2User {
	
	@Id
	private String uid;
	private String pass;
	private String name;
	private int age;
	private String hp;
	private String role; // User, Manager, Admin
	
	@CreationTimestamp
	private LocalDateTime regDate;

	// 추가필드
	private String provider;
	private String nickname;
	private String email;

	@Override
	public Map<String, Object> getAttributes() {
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
}
