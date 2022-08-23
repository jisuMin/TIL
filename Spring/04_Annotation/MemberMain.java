package annotation.memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		ApplicationContext cm = new ClassPathXmlApplicationContext("annotation/memberservice/member.xml");
		
		MemberService service = (MemberService)cm.getBean("service1"); //autowired된 service1,2 구분해서 사용 
		service.registerMember();	

	}

}
