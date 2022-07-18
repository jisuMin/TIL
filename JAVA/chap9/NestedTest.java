package chap9;

class A{
	int v = 10; //A 클래스 변수
	B b1=new B(); //멤버변수처럼 사용 - 중첩 클래스 객체 생성 위치 A 내부
	class B{
		int x=20;
		void bmethod() {
			System.out.println(x);
			System.out.println("v=" + v); // 외부클래스 선언 멤버변수 사용 가능
		}
	}
	static class C{ //원래 class엔 static 선언 x,중첩(내부) 클래스엔 가능
		int y=30;
		void cmethod() {
			System.out.println(y);
		}
	}
	void amethd() {
		//class D{ //메소드 내부 클래스 선언}
		B b2 = new B(); //중첩 클레스 타입 객체 지역변수 
		System.out.println(b2.x);
	}
}

public class NestedTest {

	public static void main(String[] args) {
		A a2 = new A();
		a2.amethd();
		
		A a1 = new A();
		System.out.println(a1.b1.x);
		a1.b1.bmethod();
		
		A.B b2 = new A().new B(); //내부 클래스 B 객체를 만들어라
		System.out.println(b2.x);
		b2.bmethod();
		
		//static 멤버변수
		A.C c2 = new A.C();
		System.out.println(c2.y);
		c2.cmethod();
	}

}
