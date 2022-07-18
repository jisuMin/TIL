package generic;

class Apple{
	String origin;
	Apple(String origin){
		this.origin=origin;
	}
}

class Paper{
	String size; //A4
	Paper(String size){
		this.size=size;
	}
}
class TwoBox<T1, T2>{ //type parpameter = 클래스타입 전달   
	T1 o1;
	T2 o2;
	TwoBox(T1 o1, T2 o2){
		this.o1 = o1;
		this.o2 = o2;
	}

}
class ThreeBox<T extends Number>{ 
	//Integet, Double, Byte 등 Number의 하위클래스들로 제한 => String 안됨
	T num;
	ThreeBox(T num){
		this.num=num;
	}

}

class Box<T>{ //type parpameter = 클래스타입 전달   
	T contents; 

	public T getContents() {
		return contents;
	}

	public void setContents(T contents) {
		this.contents = contents;
	}
}

public class BoxTest {

	public static void main(String[] args) {
		//하위클래스 타입 파라미터 전달
		ThreeBox<Integer> threebox = new ThreeBox(100);
		ThreeBox<Double> threebox2 = new ThreeBox(567.89);
		System.out.println(threebox.num.getClass().getName());
		System.out.println(threebox2.num.getClass().getName());
		
		//ThreeBox<String> threebox3 = new ThreeBox(567.89);
	}
		/*TwoBox<Apple, Paper> twobox = new TwoBox(new Apple("영주"), new Paper("B5"));
		System.out.println(twobox.o1.getClass().getName());
		System.out.println(twobox.o2.getClass().getName());
		
		TwoBox<String, Integer> twobox2 = new TwoBox("영주",100);
		System.out.println(twobox2.o1.getClass().getName());
		System.out.println(twobox2.o2.getClass().getName());
	}
		//명령행 매개변수 - apple 대구
		Apple a = null;
		Paper p = null;
		if(args[0].equalsIgnoreCase("apple")) {
			a = new Apple(args[1]);
			Box<Apple> b1 = new Box<Apple>();
			b1.setContents(a);
			Apple o = b1.getContents();
			System.out.println(o.origin);
		}else if (args[0].equalsIgnoreCase("paper")) {
			p=new Paper(args[1]);
			Box<Paper> b2 = new Box<Paper>();
			b2.setContents(p);
			Paper o = b2.getContents();
			System.out.println(o.size);
		}
	}*/

}
