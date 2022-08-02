class Person{
	//이름, 나이, 국적
	String name;
	int age;
	final static String nation ="대한민국";//final로 static값을 변경하지 못하게 한다. 
	
	void showPerson() { //non-static 메소드 내부에서는 non-static  변수와 static 변수 모두 사용 가능 
		System.out.println(name+ " : " +age+ " : " +nation);
	}
	static void showNation() {//non-static 메소드 내부에서는 static 변수만 사용 가능 
		System.out.println("모든 사람의 국적 = "+ nation);
	}
}

public class StaticTest2 {

	public static void main(String[] args) {

		Person.showNation();
		Person p1 = new Person();
		p1.name ="김한국";
		p1.age=27;
		p1.showPerson();

		Person p2 = new Person();
		p2.name ="박대한";
		p2.age=37;
		p2.showPerson();
		

	}

}
