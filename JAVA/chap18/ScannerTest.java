package chap18;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("2개의 정수를 입력하면 덧셈 결과를 출력합니다.");
		int first = sc.nextInt(); //int값을 읽는다. 
		int second = sc.nextInt();
		System.out.println("덧셈 결과 : "+(first+second));
		System.out.println("한글 데이터를 입력하면 한글 출력");
		sc.nextLine();
		String third = sc.nextLine();
		System.out.println(third);
	}

}
