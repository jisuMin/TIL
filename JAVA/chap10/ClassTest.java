package chap10;

public class ClassTest {

	public static void main(String[] args) {
		//명령행 매개변수 - B타입 객체
		//args[0] 입력 클래스명의 객체 생성 - 객체 동적 다르다
		//클래스에 존재하지 않을 수 있다.
		
		//입력 문자열 클래스명 해석해서 실제 클래스 타입으로 변환 
		try {
			
			Class c = Class.forName(args[0]); //입력한 문자열을 클래스타입으로 변환 
			Object o = c.newInstance(); // 클래스타입의 객체 생성 
			System.out.println(o.getClass().getName()); //생성 객체 타입 출력 
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
