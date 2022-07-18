package chap3;

public class MainMethodTest {
//김한국 100 자바 -3개
//김한국100자바 - 공백이 없으면 1개
// "김한국 100 자바" - 따음표 안에 공백이 있어도 1개 

	public static void main(String args[]) {//args[] String 배열 타
		System.out.println("명령행 매개변수 갯수 = "+args.length);
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i]);
		}
		//100 200 덧셈 출력 결
		//agrs를 받을 때 String 으로 받기 때문 
		System.out.println(args[0]+args[1]); //args[0]는 String 타입 
		//String -> 정수로 바꿔 덧셈 처리하기 
		int first =Integer.parseInt(args[0]);
		int second =Integer.parseInt(args[1]);
		System.out.println(first+second);
		
		double result = Double.parseDouble("3.14");
		System.out.println(result+result); //String으로 입력했지만 double로 변경함 
	}

}
