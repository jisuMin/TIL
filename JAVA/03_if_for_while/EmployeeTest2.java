class Employee{
	int id;
	String name;
	double pay;
	String dept;
	String title;
	//메소드
	Employee(int i,String n, double p, String d, String t){
	this.id=i;
	this.name=n;
	this.pay=p;
	this.dept=d;
	this.title=t;

	}//자동정의 
	Employee(int id, String name, double pay){
		/*this.id=id;
		this.name=name;
		this.pay=pay;
		this.dept="직급발령"; //매개변수에 없는 건 this를 생략해도 된다. 
		this.title="부서이동중";*/
		//this.(id,name,pay,"부서이동중","발령이전");
	}
	Employee(){
		this.id=-1;
		this.name="없음";
		this.pay=-1;
		this.title="미정";
		this.dept="미정";
	}
}
public class EmployeeTest2 {

	public static void main(String[] args) {
		Employee e1 = new Employee(100,"이사원",1000,"it","사원"); //생성자 호출됨 
		/* 1> e1변수 stack 저장 2> new 변수와 메소드 heap저장
		 * 3> 생성자 정의 내용 실행 4> e1 변수에 주소 저장 */
		/*e1.name="이사원";
		e1.id=100;
		e1.dept="it";
		e1.title="사원";*/
		
		System.out.println("사번=" + e1.id + " , 이름=" + e1.name + " , 급여=" + e1.pay
				+", 부서명="+e1.dept+", 직급="+e1.title);
		
		Employee e2 = new Employee(200,"김대리",1500); //생성자 호출됨 
		//e2.name="김대리";
		//e2.id=200;
		//e2.dept="인재개발부";
		//e2.title="대리";
		System.out.println("사번=" + e2.id + " , 이름=" + e2.name + " , 급여=" + e2.pay
				+", 부서명="+e2.dept+", 직급="+e2.title);

		Employee e3 = new Employee();		
		System.out.println("사번=" + e3.id + " , 이름=" + e3.name + " , 급여=" + e3.pay
				+", 부서명="+e3.dept+", 직급="+e3.title);

	}

}
