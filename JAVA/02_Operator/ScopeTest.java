package chap3;

public class ScopeTest {

	public static void main(String[] args) {
		String a = "메인 메소드에서 선언";
		int i=1;
		if(i==1) {
			a="if 블럭에서 사용"; // 변수값 새로운 값 할당 
			String b= "if블록에서 새롭게 선언한 변수";//scope : if블
		}
		System.out.println(a);
		// 여기서 b 출력 불가능 - if 블록을 벗어났기 때문 
	}

}
