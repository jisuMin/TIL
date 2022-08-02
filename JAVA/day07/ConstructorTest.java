package chap5;

class A{
	int i;
	String s;
	A(String s){
		//super(); object() 호출
		i=100;
		this.s=s;
	}
}

class B extends A{
	int j;
	B(){
		//super(); A() 호출
		super("전달");
		j=200;
	}
}
public class ConstructorTest {

	public static void main(String[] args) {
		B b1 = new B();
		System.out.println(b1.i);
		System.out.println(b1.j);
		System.out.println(b1.s);

	}

}
