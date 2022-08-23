package annotation.memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberScopeMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("member/member.xml");
		
		MemberDTO dto1= (MemberDTO)factory.getBean("dto1");
		MemberDTO dto2= (MemberDTO)factory.getBean("dto2");
		MemberDTO dto3= (MemberDTO)factory.getBean("dto3");
		
		System.out.println(dto1);
		System.out.println(dto2);
		System.out.println(dto3);

	}

}
