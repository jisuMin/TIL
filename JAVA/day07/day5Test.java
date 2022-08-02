package chap5;

class Bird{
	String name;

	int legs;
	int length;
	
	
	void fly() {	}
	void sing() {
		System.out.println(name+"가 소리내어 웁니다.");
	}
	void setName() {
		String sound;
		if(name.equals("오리")) { sound = "꽥꽥" ;}
		else { sound = "짹쨱" ;}
	}
	void print() {
		//split - 문자열 분리 -> String 배열로 리턴받음 
		String[] sp_name = name.split("[(]");
		System.out.println(sp_name[0]);
	}
}

class Duck extends Bird{ 
	int web;
	
	
	void  fly() { System.out.println(name+")는 날지 않습니다."); }
	void swim() {
		System.out.println(name+ "가 " +web+ "개의 물갈퀴로 수영합니다.");
	}
}

class Sparrow extends Bird{
	String friend;
	
	void makeFriend() {
		System.out.println(name+"의 친구는 "+friend+"입니다.");
	}
	void  fly() { System.out.println(name+")는 날아다닙니다."); }
}

class PlayBird{
	
}
public class day5Test {

	public static void main(String[] args) {
		Duck d = new Duck();
		Sparrow s = new Sparrow();
		d.web=2;
		d.name="오리(꽥꽥이)";
		d.fly();			
		d.sing();
		d.swim();
		d.print();
		
		s.name="참새(쨱쨱)";
		s.fly();	
		s.sing();				
		s.friend="허수아비";
		s.makeFriend();
		s.print();
	}

}
