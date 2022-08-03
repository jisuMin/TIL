class Circle {
	//반지름, 원주율
		int radius;
		final double pi=3.14; //원주율은 동일하기 때문에 값을 고정시키기 위해 final 사용
		int x=100; //원의 중심 x
		int y=200; //원의 중심 y
		String title ="ai 플랫폼";
}

public class FinalTest {

	public static void main(String[] args) {
		//반지름 5인 원을 생성 - 면적 구하여 출력
		Circle c = new Circle();
		//c.pi = c.pi +1; pi는 final 변수이기 때문에 다른 값으로 바꿀 수 없음 
		c.radius=5;
		c.x=c.x*2;
		double area=c.radius* c.radius *c.pi;
		System.out.println(c.radius);
		System.out.println("원의 중심 (x,y) = "+c.x+", "+c.y+" 인 원의 반지름은 "+c.radius+"이고 ");
		System.out.println(" 원의 면적은 "+area+" 입니다.");
		
		
	}

}
