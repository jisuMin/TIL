package chap3;

public class ReturnTest {
	public static void test() {
		System.out.println("test 실행");
		if(true) {return;}
		System.out.println("test 종료");
	}
	public static void main(String[] args) {
		System.out.println("main 실행");
		test(); //test 호출 실
		System.out.println("main 종료");
	}

}
