package chap3;

public class DiceTet {

	public static void main(String[] args) {
		//주사위 2개를 던져서
		// 2개 주사위 눈의 숫자와 합 출력
		//이 때 눈의 합이 5이면 중단하기
		
		/*int dice1 = (int)(Math.random()*6)+1;
		int dice2 = (int)(Math.random()*6)+1;
		int sum=0;
		int x=0;
		while(sum!=5) {
			System.out.println("("+dice1+ "," +dice2+") = "+sum+"\n");
			dice1 = (int)(Math.random()*6)+1;
			dice2 = (int)(Math.random()*6)+1;
			sum= dice1 + dice2;
			x++;
		}
		System.out.print("("+dice1+ "," +dice2+") = : "+sum+"\n");
		System.out.println(" => 합이 5, 중단합니다." +x+"번 실행되었습니다.");*/
		int dice1 =0;
		int dice2=0;
		int sum=0;
		/*while (true) {
			dice1 = (int)(Math.random()*6)+1;
			dice2 = (int)(Math.random()*6)+1;
			sum= dice1 + dice2;
			if(sum!=5) {
				System.out.print("("+dice1+ "," +dice2+") = : "+sum+"\n");
			}
			else {
				break;
			}
		}
		System.out.print("("+dice1+ "," +dice2+") = : "+sum+"\n");
		System.out.println(" => 합이 5, 중단합니다.");*/
		
		while (true) {
			dice1 = (int)(Math.random()*6)+1;
			dice2 = (int)(Math.random()*6)+1;
			sum= dice1 + dice2;
			System.out.print("("+dice1+ "," +dice2+") = : "+sum+"\n");
			if(sum==5) {
				System.out.println(" => 합이 5, 중단합니다.");
				break;
				
			}
		}
	}

}
