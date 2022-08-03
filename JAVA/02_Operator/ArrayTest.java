package chap3;

public class ArrayTest {

	public static void main(String[] args) {
		int scores [] = new int[10]; //선언과 생성 동시
		System.out.println("학생수 = "+scores.length);

		//scores 배열 값 10개 "반복" 출력
		for (int index=0;index<10;index++) {
			System.out.println(scores[index]);
		}
		
		for (int index=0; index<10;index++) {
			scores[index]=(int)(Math.random()*100)+1;
			System.out.println(scores[index]);
		}
		
		int sum=0;
		int avg=0;
		for (int index=0; index<10;index++) {
			sum+=scores[index];
		}
		avg=sum / scores.length;
		System.out.println("합계 : "+sum+"평균 : "+avg);
		
		int max=0;
		for(int index=0;index<scores.length;index++) {
			if(scores[index]>max) {
				max=scores[index];
			}
		}System.out.println("1등 : "+max);
		
		int min=999;
		for(int index=0;index<scores.length;index++) {
			if(scores[index]<min) {
				min=scores[index];
			}
		}System.out.println("꼴등 : "+min);
	}// end of main

}
