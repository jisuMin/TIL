package chap10;

import java.text.DecimalFormat;

public class DecimalFormatTest {

	public static void main(String[] args) {
		double num = 1234567.89;
		//# 정수 부분 - 표현 숫자가 더 커도 잘 표현됨
		DecimalFormat df = new DecimalFormat("###,###.##"); //6자리 정수.2자리 소수
		System.out.println(df.format(num));
		double num1 = 34567.89;
		df = new DecimalFormat("000,000.#"); //1자리 소수(반올림됨), 정수 모자르는 부분은 0으로 채워라
		System.out.println(df.format(num1));
		df = new DecimalFormat("000,000.#"); //1자리 소수(반올림됨), 정수 모자르는 부분은 0으로 채워라
		System.out.println(df.format(num1));
	}

}
