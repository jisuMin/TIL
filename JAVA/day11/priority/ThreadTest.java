package priority;

class A extends Thread{

	A(String name){
		super(name);
	}
	@Override
	public void run() { 
		System.out.println(getName()+"우선순위 = " + getPriority());
		for (int i=1;i<=100;i++) {
			try {
				Thread.sleep(1000);// 1초 멈춰라
			}catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
			System.out.println(getName() + "스레드 = " +i);
		}
	}
	
}
public class ThreadTest {

	public static void main(String[] args) {
		A a1 = new A("one");
		A a2 = new A("two");
		a1.setPriority(Thread.MIN_PRIORITY); //a1의 우선순위 최하위로  => 1
		a2.setPriority(Thread.MAX_PRIORITY); //a2의 우선순위는 최상위로 => 10 / 우선순위가 높다 = 먼저 실행이 끝날 가능성을 준다는 뜻
		a1.start(); 
		a2.start();
		System.out.println("main종료");

	}

}
