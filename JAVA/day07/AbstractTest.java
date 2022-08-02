package chap5;

abstract class Shape{
	String name;
	abstract void area();
	abstract void circum();
}

class Circle extends Shape{
	int radius;
	final double pi=3.14;
	//생성자 정의

	Circle (String name, int r) {
		this.name=name;
		radius=r;
	}
	//area, circum 오버라이딩 -> shape에 선언한 리턴타입과 매개변수 똑같게
	void area() {
		System.out.println("반지름이 "+radius+"인 "+name+"의 면적 : "+radius*radius*pi);
	}
	void circum() {
		System.out.println("반지름이 "+radius+"인 "+name+"의 둘레 : "+radius*2*pi);
	}
}
class Rectangle extends Shape{
	int width;
	int height;
	//생성자 
	Rectangle(String name, int w, int h){
		this.name=name;
		width =w;
		height=h;
	}
	// area, circum 오바라이딩
	void area() {
		System.out.println("가로 "+width+", 세로"+height+"인 "+name+"의 면적 : "+(width*height));
	}
	void circum() {
		System.out.println("가로 "+width+", 세로"+height+"인 "+name+"의 둘레 : "+(width*height)*2);
	}
}

public class AbstractTest {

	public static void main(String[] args) {
		Circle c = new Circle("원",5);
		Rectangle r = new Rectangle("사각형",6,8);
		c.area();
		r.area();
		c.circum();
		r.circum();
	}

}
