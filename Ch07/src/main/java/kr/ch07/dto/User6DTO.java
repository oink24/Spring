package kr.ch07.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User6DTO {

	private String uid;
	private String name;
	private String birth;
	private int gender;
	private int age;
	private String address;
	private String hp;
}
