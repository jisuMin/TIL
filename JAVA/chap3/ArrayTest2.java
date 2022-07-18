package chap3;

public class ArrayTest2 {

	public static void main(String[] args) {
		String names[]= {"김한국","박대한","최우리","이강산","오아름"};
		int scores [] = new int[5]; //선언과 생성 동시
		System.out.println("학생수 = "+names.length);

		//scores 배열 값 10개 "반복" 출력
		/*for (int index=0;index<scores.length;index++) {
			System.out.println(names[index]);
			System.out.println(scores[index]);
		}*/
		
		//10명 학생 점수 저장 - 초기화 
		for (int index=0; index<scores.length;index++) {
			scores[index]=(int)(Math.random()*100)+1;
			System.out.println(names[index]+"학생의 점수 : "+scores[index]);
			
		}
		
		int sum=0;
		int avg=0;
		for (int index=0; index<scores.length;index++) {
			sum+=scores[index];
		}
		avg=sum / scores.length;
		System.out.println("합계 : "+sum+"평균 : "+avg);
		
		int max=0; 
		String name="";
		for(int index=0;index<scores.length;index++) {
			if(scores[index]>max) {
				max=scores[index];
				name=names[index];
			}
		}System.out.println("1등 : "+max+"- 이름 : "+name);
		
		int min=999;
		for(int index=0;index<scores.length;index++) {
			if(scores[index]<min) {
				min=scores[index];
				name=names[index];
			}
		}System.out.println("꼴등 : "+min+"- 이름 : "+name);
	}// end of main

}
