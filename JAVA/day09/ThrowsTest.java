package chap10;

import java.io.FileNotFoundException;
import java.io.FileReader;

class Test{
	void m1(int i) throws ArithmeticException {
		System.out.println(100/i);
	}
	void m2() {
		m1(0);
	}//m2 end
	void m3() {
		try {
			m1(0);
		}catch (ArithmeticException e) {
			m1(100);
		}
	}//m3 end
	void m4() {
		try {
			FileReader fr = new FileReader("a.txt");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

public class ThrowsTest {

	public static void main(String[] args) {
		Test t1 = new Test();
		t1.m2();
		t1.m3();
		t1.m4();
	}

}
