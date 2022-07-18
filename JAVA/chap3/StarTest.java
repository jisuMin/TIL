package chap3;

public class StarTest {

	public static void main(String[] args) {
		
		int lines=5;
		for (int i=1;i<=lines;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}// end of for j
			System.out.println();
		}//end of for i
		System.out.println("=========================");
		
		for (int i=1;i<=lines;i++) {
			for(int j=lines;j>=i;j--) {
				System.out.print("*");
			}// end of for j
			System.out.println();
		}//end of for i
		
		System.out.println("=========================");
		
	}//end of main

}
