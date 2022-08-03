package chap3;

public class ForTest {

	public static void main(String[] args) {
		// 1 -10 정수 출력
		/*for (int i=1; i<=10; i++) {
			System.out.println(i);
		}
		
		// 1-10 까지 합
		int sum=0;
	    for(int j=1;j<=10;j++) {
	    	sum+=j;
	    }
	    System.out.println(sum);*/
		
		/*int sum=0;
		int i=1;
		do {
			System.out.println(i);
			sum+=i;
			i++;
		}while(i<=10);
		System.out.println(sum);*/
		
	/*	int sum=0;
		int i=1;
		while(i<=10){
			System.out.println(i);
			sum+=i;
			i++;
		}
		System.out.println(sum);*/
		
		// 1-50 사이의 난수를 발생시켜 10의 배수가 아니면 출력, 10의 배수이면 중단
		int su=(int)(Math.random()*50)+1;
		while(su % 10 !=0) {
				System.out.println(su);		
				su=(int)(Math.random()*50)+1;
			}//end of while
		


	}//end of main

}//end of class
