package chap5;

final class Math{
	    int abs(int i) {
		if(i>=0) { return i;}
		else { return i*-1;}
	}
}

class MyMath //extends Math 
	{
	//양수이면 음수로, 음수이면 그대로 리턴
	Math i = new Math();
	/*public int abs(int i) {
		if(i<=0) { return i;}
		else { return i*-1;}
	}*/
}
public class FinalTest {

	public static void main(String[] args) {
	 
		MyMath m = new MyMath();
		int r1 = m.i.abs(10);
		System.out.println(r1);
	}

}
