package chap12;


public class RunnableTest2 {

	public static void main(String[] args) {
		Runnable r1 = new Runnable(){
			public void run() {
				for(int i=1;i<=10;i++) {
					System.out.println("스레드 = "+i);
				}
			}
			//변수 메소드 생성자 추가는 무상관
		};
		Thread ta1=new Thread(r1);
		
		ta1.start(); //run() 호출하는 시점에서 cpu는 main 실행 대기
		
		System.out.println("main종료");

	}

}
