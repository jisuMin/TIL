package chap12;

class A extends Thread{
	//변수 메소드 생성자 추가는 무상관
	String name;
	A(String name){
		this.name = name;
	}
	@Override
	public void run() { //thread 상속 시 run 메소드 필수 
		for (int i=1;i<=10;i++) {
			System.out.println(name + "스레드 = " +i);
		}
	}
	
}
public class ThreadTest {

	public static void main(String[] args) {
		A a1 = new A("one");
		A a2 = new A("two");
		a1.start(); //run() 호출하는 시점에서 cpu는 main 실행 대기
		a2.start();//run()을 호출하면 멀티스레드로 실행되지 않음
		System.out.println("main종료");

	}

}
