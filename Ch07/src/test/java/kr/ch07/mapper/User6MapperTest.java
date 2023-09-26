package kr.ch07.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ch07.dto.User6DTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class User6MapperTest {
	
	@Autowired
	private User6Mapper mapper;
	
	@Test
	public void insertUser6() {
		
		User6DTO user6 = User6DTO.builder()
				.uid("B101")
				.name("홍길동")
				.birth("1989-01-01")
				.gender(1)
				.age(34)
				.address("인천광역시")
				.hp("010-1234-1001")
				.build();
		
		mapper.insertUser6(user6);
		log.info("user6 : "+user6);
	}
}
