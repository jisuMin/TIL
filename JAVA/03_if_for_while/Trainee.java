package day4_Test;

class student{
	//이름, 소속, 과정명, 교육비, 부가금 
	String name;
	static String dept="멀티캠퍼스";
	String title;
	int pay;
	int charge;
}

public class Trainee {

	public static void main(String[] args) {
		student s1 = new student();
		s1.name=args[0];
		s1.title=args[1];
		s1.pay=Integer.parseInt(args[2]);
		s1.charge=Integer.parseInt(args[3]);
		
		
		String d = args[1]; // 과목명 저
		int refund;
		if(d.equals("자바프로그래밍")) {
			refund = (int) (s1.pay *0.25 +s1.charge);
		}else if (d.equals("JDBC프로그래밍")) {
			refund = (int) (s1.pay *0.20 +s1.charge);
		}else if (d.equals("JSP프로그래밍")) {
			refund = (int) (s1.pay *0.15 +s1.charge);
		}else {
			System.out.println("잘못 입력되었습니다. 메소드 중단합니다.");
			return;
		}
		System.out.println("이름 = "+s1.name+", 소속 = "+s1.dept+", 과정명 = "+s1.title);
		System.out.println("교육비 = "+s1.pay+", 부가금 = "+s1.charge+", 환급금 = "+refund);

	}

}
