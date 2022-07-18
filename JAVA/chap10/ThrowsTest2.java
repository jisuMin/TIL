package chap10;

import java.io.FileNotFoundException;
import java.io.FileReader;

class A {
	void m1(int i) throws FileNotFoundException {
		System.out.println(100/i);
		FileReader fr = new FileReader("b.txt");
	}
	void m2() throws FileNotFoundException {
		m1(0);
	}
}

public class ThrowsTest2 {

	public static void main(String[] args) throws ArithmeticException, FileNotFoundException{
		A a1 = new A();
		a1.m2();

	}

}
