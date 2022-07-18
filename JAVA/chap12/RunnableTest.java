package chap12;

class B implements Runnable{
	//변수 메소드 생성자 추가는 무상관
	String name;
	B(String name){
		this.name = name;
	}
	@Override
	public void run() { //thread 상속 시 run 메소드 필수 
		for (int i=1;i<=10;i++) {
			System.out.println(name + "스레드 = " +i);
		}
	}
	
}
public class RunnableTest {

	public static void main(String[] args) {
		B b1 = new B("one");
		B b2 = new B("two");
		Thread ta1=new Thread(b1);
		Thread ta2 =new Thread(b2);
		ta1.start(); //run() 호출하는 시점에서 cpu는 main 실행 대기
		ta2.start();//run()을 호출하면 멀티스레드로 실행되지 않음
		System.out.println("main종료");

	}

}
