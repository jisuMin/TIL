package chap2;

public class VariableTest {

	public static void main(String[] args) {
		boolean b1= true;
		boolean b2= false;
		boolean b3=10>0;
		
		System.out.println("b1의값 출력= " + b1);
		System.out.println("b2의값 출력= " + b2);
		System.out.println("b3의값 출력= " + b3);
		
		int i1=100;
		int i2=200;
		System.out.println(i1+i2); //300
		System.out.println("i1+i2= "+i1+i2); // i1+i2= 100200
		System.out.println("i1+i2= "+(i1+i2)); // i1+i2= 300
		System.out.println("int 최대값 = "+Integer.MAX_VALUE); //int 4byte = 32bit -> -s^31 ~ 2^31-1
		System.out.println("int 최소값= "+Integer.MIN_VALUE);
		
		char c1='다'; //char 문자열은 한 문자만 선언
		char c2='\n';
		
		System.out.println("c2="+c2);
		System.out.println("c1="+c1);
		
		int i4=65;
		char c4='A';
		System.out.println(i4+c4); //130
		System.out.println((char) i4);
		System.out.println((int)c4);
		
		// A=65, a=97 - 대문자를 소문자로 변 (65+32), - 소문자를 대문자로 변환(97-32)
		
		
	}

}
