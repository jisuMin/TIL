class Outer{
	int i=10;
	class Inner{
		int j=20;
		void innermethod() {
			System.out.println(j);
		}
	}
	static class Inner2{
		int k=30;
	}
	void outermethod() {
		class Inner3{
			int n=40;
		}
	}//Inner i3=new Inner3();
}
public class InnerTest {

	public static void main(String[] args) {
		Outer o=new Outer();
		System.out.println(o.i);
		Outer.Inner oi = o.new Inner();
		System.out.println(oi.j);
		oi.innermethod();
		
		//Inner i = new Inner(); //오
		

	}

}
