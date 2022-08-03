package chap3;

public class ifTest {

	public static void main(String[] args) {
		
		//System.out.println(int)(Math.random()*45)+1); 1 ~ 45
		
		String name="김학생";
		int kor=(int)(Math.random()*100)+1; //1-100 값 난수 발생 - 원래 난수의 값은 실수 0<= 난수 <1
		int eng=(int)(Math.random()*100)+1;
		int mat=(int)(Math.random()*100)+1;
		
		int sum=kor+mat+eng;
		int avg=sum/3;
		System.out.println("학생명 =" +name);
		System.out.println("국어 =" +kor);
		System.out.println("영어 =" +eng);
		System.out.println("수학 =" +mat);
		System.out.println("총점 =" +sum);
		System.out.println("평균 =" +avg);
		
		//평군 80 이상이면 "수료" / "미수료" 출력
		//String result = avg>=80?"수료":"미수료";
		/*if (avg>=80) {
			System.out.println("수료");
		}
		else { System.out.println("미수료");}*/
		
		String result="";
		if (avg>=80) {result="수료"; }
		else { result="미수료";}
		System.out.println(result);
		
		// 3단계로 나누기 
		/*if(avg >= 90) { System.out.println("A");}
		else if(avg>=70) { System.out.println("B");}
		else if(avg>=50) { System.out.println("C");}
		else {System.out.println("F");}*/
		
		/*String grade="";
		if(avg >= 90) { grade="A";}
		else if(avg>=70) { grade="B";}
		else if(avg>=50) { grade="C";}
		else {grade="F";}
		System.out.println(grade);*/
		
		String grade="";
		switch (avg/10) {
		case 10:
		case 9: grade="A"; break;
		case 8:
		case 7:grade="B"; break;
		case 6:
		case 5:grade="C"; break;
		default: grade="F";
		}//end of switch
		System.out.println(grade);

	}//end of main

}//end of class
