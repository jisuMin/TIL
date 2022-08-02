package chap18;

import java.text.DecimalFormat;
import java.util.Scanner;

class Employee{
	int id;
	String name;
	double pay;
	public Employee(int id, String name, double pay) {
		super();
		this.id=id;
		this.name=name;
		this.pay=pay;
	}
	public String toString() {
		DecimalFormat df= new DecimalFormat("#,###.00");
		return id +" 사번의 "+ name +" 사원은 연봉은 "+ df.format(pay*12) + "입니다.";
		
	}
}
public class ScannerTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("사번 이름 월급여 순으로 입력 : ");
		String line = sc.nextLine();
		String[] word = line.split(" ");
		int id = Integer.parseInt(word[0]);
		String name = word[1];
		double pay = Double.parseDouble(word[2]);
	/*System.out.print("사원의 사번 : ");int id = sc.nextInt();
		System.out.print("사원의 이름 : ");String name = sc.next();
		System.out.print("사원의 월급여 : ");double pay = sc.nextDouble();*/
		Employee e = new Employee(id,name, pay);
		System.out.println(e);
	}

}
