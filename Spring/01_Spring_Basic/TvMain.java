package spring.tv;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvMain {

	public static void main(String[] args) {
		//TVFactory factory = new TVFactory();
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/tv/tv.xml");
		TV tv = (TV)factory.getBean("tv");	//xml에 설정한 bean id 가져오기
		tv.powerOn();
		tv.volumUp(10);
		tv.volumDown(5);
		tv.powerOff();
		

	}

}
