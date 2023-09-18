package sub2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 날짜 : 2023/09/18
 * 이름 : 강나은
 * 내용 : 스프링 컨테이너 실습
 * 
 * DI
 *  - DI : Dependency Injection(의존성 주입) 의미로 객체를 생성하는 방식이 아닌 컨테이너로부터 주입받는 방식
 *  - 생성자, setter, 필드의 3가지 주입 방식
 *  - @Component 선언으로 객체를 컨테이너에 등록/관리
 *  - @Component는 @Controller, @Service, @Repository로 세분화
 */
public class SpringContainerTest {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		Computer com = (Computer) ctx.getBean("com");
		com.show();
	}
}
