package kr.ch09.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "User")
public class UserEntity {
	
	@Id
	private String uid;
	private String pass;
	private String name;
	private int age;
	private String hp;

	@ColumnDefault("USER")
	private String role; // USER, MANAGER, ADMIN
	
	@CreationTimestamp
	private LocalDateTime regDate;
}
