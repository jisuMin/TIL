package priority;
class C extends Thread{
	int data =10;
	public void run() {
		try {
			Thread.sleep(20000);
		}catch (InterruptedException e) {} //아무일도 처리하지 말라.
		data=data*2;
		System.out.println("run 메소드 = "+data);
	}
}
public class JoinTest {

	public static void main(String[] args) {
		System.out.println("메인 시작");
		C c1 = new C(); //멀티스레드객체 생성 c1.data => 10
		c1.start();//run 즉각실행 x, 실행준비 실행전 c1.data => 10 실행후 c1.data => 20
		try {
			c1.join(); //cpu를 c1 스레드 실행 변경. c1.run 수행. main 중단.
		}catch(InterruptedException e) {}
		System.out.println(c1.data); //run 수행결과 출력
		System.out.println("메인 종료");
	}

}
