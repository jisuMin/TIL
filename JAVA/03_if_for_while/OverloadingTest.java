
class C{
	int add(int i, int j) {
		return i+j;
	}
	String add(String i, String j){
		return i+j;
	}
	double add(double i, double j, double k){
		return i+j+k;
	}
}//메소드명은 같고 매개변수 리스트가 달라야 오버로딩 , 리턴타입은 무관 

public class OverloadingTest {

	public static void main(String[] args) {
		C c1= new C();
		//1. 갯수 일치 ---> 2. 타입 일치 
		String r1=c1.add("java", "과정");
		int r2=c1.add(10,20);
		double r3=c1.add(2, 3.3, 1.1); //2는 int지만 자동으로 double로 인식 가능 
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		int decimal = Integer.parseInt("100");
		int bin = Integer.parseInt("100", 2); //100d을 2진수로 변환
		int decimal2 = Integer.parseInt("12345678",5, 7, 10); //5번 인덱스부터 7번 이전까지 = 5,6 인덱스 = 67를 10진수로 
		System.out.println(decimal);
		System.out.println(bin);
		System.out.println(decimal2);
	}

}
