package chap3;

public class GugudanTest {

	public static void main(String[] args) {
		//int dan=2;
		
		for (int i=1;i<=9;i++) {
			for(int dan=2;dan<=9;dan++) {
				//if(dan==6) {break;} //구구단 5단까지 출력 
				if(dan==6) {continue;} // 6단빼고 출
				System.out.print(dan + "*"+i+"="+dan*i+"\t");
			}//end of for dan
			System.out.println();

		}//end of for i
		
		
	}//end of main

}//end of class
