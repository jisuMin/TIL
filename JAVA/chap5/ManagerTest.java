package chap5;

class Employee{
	int id;  
	String name="회사원"; // static이 있으면 employee.name / manager.name 으로 구분 가능
	double pay;
	void printInform() {
		System.out.println(id+":"+name+":"+pay);
	}
}


class Manager extends Employee{
	String name="관리직";
	String jobofManage;
	void test() {
		System.out.println(id);
	}
	@Override
	protected void printInform() {
		System.out.println(id+":"+name+":"+pay);
		System.out.println(jobofManage);
	}
}
public class ManagerTest {

	public static void main(String[] args) {
		Manager m = new Manager();
		m.id=200;
		//m.name="홍길동";
		m.pay=34500.99;
		m.jobofManage="it관리";
		System.out.println(m.id);
		System.out.println(m.name);
		System.out.println(m.pay);
		System.out.println(m.jobofManage);
		m.printInform();
	}

}
