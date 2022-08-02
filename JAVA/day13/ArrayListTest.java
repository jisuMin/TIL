package chap15;

import java.util.ArrayList;

class Employee{
	int id;
	String name;
	double pay;
	Employee(int id, String name, double pay){
		this.id = id;
		this.name=name;
		this.pay= pay;
	}

	public String toString() {
		return id+" " +name+" "+pay;
	}

}
public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<Employee>(5);//저장공간이 넘어도 자동으로 늘어남 (5개씩)
		
		/*list.add("java");
		list.add(100);
		list.add(3.14);
		list.add("jsp");
		list.add(true);
		list.add('a');*/
		Employee e1 = new Employee(100,"김사원",67000.88 );
		list.add(e1);
		Employee e2 = new Employee(200,"박대리",77000.88 );
		list.add(e2);
		Employee e3 = new Employee(300,"최과장",87000.88 );
		list.add(e3);
		System.out.println(list.size());
		//add(Object o) 
		
		for(int i=0;i<list.size();i++) {
			System.out.println(i+" 번째 위치 값 : "+list.get(i).name); 
		}
	}

}
/*
//컬렉션 프레임워크 기본형변수 x, 객체들만 저장 o
		//int = Integer => 같은 타입 간주 
		int i = 100;
		Integer in = new Integer(100); in.toBinaryString(100);
		Integer in2 = 100;
		int i2 = new Integer(100);*/