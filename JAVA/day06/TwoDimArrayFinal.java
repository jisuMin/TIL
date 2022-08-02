package day4_Test;

public class TwoDimArrayFinal {

	public static void main(String[] args) {
		// 3명학생 2,3,4과목 점수 - 
		int array2 [][] = new int[3][]; 
		String names[] = new String[args.length];
		//명령행 매개변수 학생이름 3명 입력 저장 배열
		//구현
		if(args.length>=3) {
			for( int s=0;s<args.length;s++) {
			names[s]=args[s];
		}
		
		}
		// 각 학생의 총점 / 평균
		// 이름 같이 출력   
		// xxx 학생 : { 점수들 } : 해당학생의 총점 = xxx : 해당학생의 평균 : xxx
		int sum=0;
		double avg=0;
		for(int i = 0; i < array2.length; i++) { // 3	
			array2[i]=new int[i+2];
			System.out.print(names[i] +"학생 : {");	
			
			for(int j = 0; j < array2[i].length; j++) {
				array2[i][j] = (int)(Math.random() * 100)+1;
				System.out.print(array2[i][j] + " ");
				sum+=array2[i][j];//int로 선언하자마자 연산 못함, 위에 선언 후 변수 사용하기
		
			}
			avg=sum/array2[i].length; //과목 갯수만큼 나누
			System.out.println("} : 총점 = "+sum+" 평균 = "+avg);

		}//end of i
		
	}//main end

}//class end



