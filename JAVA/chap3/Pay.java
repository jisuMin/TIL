package chap3;

public class Pay {

	public static void main(String[] args) {
		String product[] = {"라면", "음료수", "계란", "사과"};
		int price[] = {500 , 2500, 8000, 1000};
		/*
		명령행 매개변수 - 7 2 1 5 카드 
		라면 7 개 음료수 2 계란 1 사과 5개 사고 카드 지불 의미 
		명령행 매개변수 - 7 2 1 5 현금 010-1234-5678 
		라면 7 개 음료수 2 계란 1 사과 5개 사고 현금 지불, 현금영수증폰번호 의미 
		1>	라면 : 500원 : 7개 : 라면총가격
		    음료수 ..
		    계란 ...
		    사과 ....
		    
		    총 지불 가격은 xxxx 원 입니다
		    선택하신 지불 수단은 명령행매개변수 5번째입력값 xxx 입니다
		    만약 현금이면 명령행매개변수 6번째입력값 
		    현금영수증처리번호는 xxxxx 입니다
		 * */
		int i1=Integer.parseInt(args[0])*500;
		int i2=Integer.parseInt(args[1])*2500;
		int i3=Integer.parseInt(args[2])*8000;
		int i4=Integer.parseInt(args[3])*1000;
		
		int result[]= {i1,i2,i3,i4};
		
		System.out.println(args[4]+args[5]);
		
		for(int i=0;i<4;i++) {
			System.out.println(product[i] + " : "+price[i]+" : "+args[i]+"개 - "+ product[i]+"총가격 : "+result[i]);
		}
			System.out.println("총 지불 가격은 "+(i1+i2+i3+i4)+"입니다.");
			System.out.println("선택하신 지불 수단은 명령행매개변수 5번째 입력값 " +args[4] +"입니다.");
		
		//출력 안됨 
		//if(args[4]=="현금"//올바르지 않음 
		if(args[4].equals("현금")) { 
			System.out.println("현금영수증 처리 번호는 " +args[5] +"입니다.");
		}
		
		
	}// end of main
} //end of class
