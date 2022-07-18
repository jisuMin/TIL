package chap14;

interface I1{
	void m1();
}
//1개의 메소드만 정의한 인터페이스일 경우만 가능 => function interface
interface I2{
	void m1(int x);
}

interface I3{
	void m1(int x, int y);
}

interface I4{
	int m1(int i, int j);
}
public class LambdaTest {

	public static void main(String[] args) {
		//매개변수 타입 생략 가능, 매개변수가 하나일 때 괄호도 생략 가능
		//{} 내부에 문장이 1문장일 때 {} 생략 가능
		I1 i1 = ()-> { System.out.println("람다테스트"); }; //매개변수가 없을 땐 () 필수 
		i1.m1();//람다식 호출 실행 
		I2 i2 = x -> System.out.println(x);
		i2.m1(10);
		I3 i3 = (x, y) -> {System.out.println(x*y); System.out.println(x+y);};
		i3.m1(5, 8);
		//리턴타입 있는 메소드에서 return 문장 1개만 구현 {} 생략, return 생략 가능
		//2개 이상인 경우 {return ...}; 구현
		I4 i4 =(i,j)-> i+j;
		int result = i4.m1(10, 20);
		System.out.println(result);
				
	}

}
