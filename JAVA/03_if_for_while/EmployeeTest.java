class Employee1{
	int id;
	String name;
	double pay;
	String dept;
	String title;
	//메소드
	Employee1(int i,String n, double p, String d, String t){
	id=i;
	name=n;
	pay=p;
	dept=d;
	title=t;
	}//자동정의 
}
public class EmployeeTest {

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
		
		Employee e2 = new Employee(200,"김대리",1500,"인재개발부","대리"); //생성자 호출됨 
		//e2.name="김대리";
		//e2.id=200;
		//e2.dept="인재개발부";
		//e2.title="대리";
		
		System.out.println("사번=" + e2.id + " , 이름=" + e2.name + " , 급여=" + e2.pay
				+", 부서명="+e2.dept+", 직급="+e2.title);

	}

}
