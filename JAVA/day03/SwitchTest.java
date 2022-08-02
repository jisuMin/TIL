package chap3;

public class SwitchTest {

	public static void main(String[] args) {
		//1-6월 중에서 각 월의 몇 일까지 있는지 출력
		// 1월 -31일까지 있습니다.
		/*int month = (int)(Math.random()*6)+1;
		int day;
		switch (month) {
		case 1: day=31; break;
		case 2: day=28; break;
		case 3: day=31; break;
		case 4: day=30; break;
		case 5: day=31; break;
		default: day=30;
		}// end of switch*/ //break가 있어야 하는 경
		
		int month = (int)(Math.random()*12)+1;
		int day;
		switch (month) {
		case 1: 
		case 3: 
		case 5: 
		case 7: 
		case 8: 
		case 10: 
		case 12: 
			day=31; break;		
		case 4:
		case 6:
		case 9:
		case 11: 
			day=30; break;
		default: day=28; //
		}
		System.out.println(month+"월은 "+day+" 까지 있습니다.");
	}// end of main

}// end of class
