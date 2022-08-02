package chap2;

public class CastingTest {

	public static void main(String[] args) {
		byte b=127; //127이상 저장시 오
		int i =b; // (int) b 같은 명시적인 형변환을 안해도 됨 - byte는 int로 변환이 가능하기 때
		System.out.println("i= "+i);
		
		double d=i; 
		System.out.println("d= "+d);
		
		double d2 =3.14;
		//int i2 = d2;
		int i2=(int)d2; //실수 값에서 정수만 가져올 수 있
		System.out.println("i2= "+i2); // 명시적형변환 (일부값 손실)
		
		int i3=128;
		byte b3=(byte) i3;
		System.out.println("b3= "+b3);
		
		char c4 ='a';
		//int i4=(int)c4; //명시적형변환
		int i4 = c4;//자동형변
		System.out.println("c4= "+c4+", i4= "+i4);//아스키코드 97
		
		char c5 ='A';
		int i5= c5;//자동형변
		System.out.println("c5= "+c5+", i5= "+i5);//아스키코드 65
		
		//소문자를 대문자로 변경
		System.out.println((char)(i4-32)); //빼기를 먼저 하여 65를 만든 후, 명시적인형변환을 하여 대문자 A를 출력한다.

		int i6=0;
		//boolean b6=(boolean)i6; //int는 boolean으로 바뀔 수 없다.
		
		int x=10;
		int y=x++; // x를 먼저 y에 대입 후 x 값 증가 
		System.out.println(y); //10이 출력되지만 메모리상 x 값은 1이 증가된 11로 저장
		x=10;
		y=++x; // x 값이 먼저 증가 후 y에 대입
		System.out.println(y); //x값이 먼저 증가되어 11이 출
		
		int s=10;
		System.out.println(s++); //출력 후 s값이 증가하기 때문에 출력된 값은 10이지만 메모리의 s값은 11이다. 
		System.out.println(s); //11로 증가된 s값 확인 
		
		int p=5;
		String result = p>10?"크다":"작다"; //결과 타입에 맞는 타입형을 선언해야한다. 
		int result2 = p>10?1:0;//조건에 오는 것은 boolean을 나눌 수 있는 조건이여야 함 
		double result3 = p>10? 1.1:0;
		
		//p가 10보다 크고 20보다 작으면 
		double result4 = p>10 && p<20? 1:0;
		
	}

}
