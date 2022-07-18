class Person1{
	//이름, 나이, 국적
	String name;
	int age;
	final static String nation ="대한민국";//final로 static값을 변경하지 못하게 한다. 
}

public class StaticTest {

	public static void main(String[] args) {
		//System.out.println("모든 사람의 국적 = "+ p1.nation); // p1이 만들어지기 전에 사용 불가 
		System.out.println("모든 사람의 국적 = "+ Person.nation); // p1 을 만들기 전엔 Person 사용 
		Person p1 = new Person();
		p1.name ="김한국";
		p1.age=27;
		//p1.nation="미국"; //static 값을 변경하면 해당 변수 내용이 다 바뀐다.
		//p1.nation="대한민국";
		System.out.println("p1 객체의 이름 = "+p1.name+" 나이 = "+p1.age+" 국적 = "+p1.nation);

		Person p2 = new Person();
		p2.name ="박대한";
		p2.age=37;
		//p2.nation="대한민국";
		System.out.println("p2 객체의 이름 = "+p2.name+" 나이 = "+p2.age+" 국적 = "+p2.nation);

	}

}
