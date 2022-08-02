package chap3;

public class TwoDimArray {

	public static void main(String[] args) {
		// 3명학생 2,3,4과목 점수 - 
		int array2 [][] = new int[3][3]; 
		String names[] = new String[args.length];
		//명령행 매개변수 학생이름 3명 입력 저장 배열
		//구현
		for( int s=0;s<args.length;s++) {
			names[s]=args[s];
			//System.out.println(names[s]);
		}
		// 각 학생의 총점 / 평균
		// 이름 같이 출력   
		// xxx 학생 : { 점수들 } : 해당학생의 총점 = xxx : 해당학생의 평균 : xxx
		int sum=0;
		double avg=0;
		for(int i = 0; i < array2.length; i++) { // 3	
			System.out.print(names[i] +"학생 : ");	
			//System.out.println(array2[i].length); 
			System.out.print("{");
			for(int j = 0; j < array2.length; j++) {
				array2[i][j] = (int)(Math.random() * 100)+1;
				System.out.print(array2[i][j] + " ");
				sum+=array2[i][j];
				avg=sum/array2.length;
			}
			
			System.out.println("} 해당학생의 총점 = "+sum+" 평균 = "+avg);

		}
		
	}//main end

}//class end



