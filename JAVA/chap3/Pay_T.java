package chap3;

public class Pay_T {

	public static void main(String[] args) {
		String product[] = {"라면", "음료수", "계란", "사과"};
		int price[] = {500 , 2500, 8000, 1000};
		int pricePerProduct[] = new int[4];
		int totalPrice =0;
		
		for(int i=0;i<4;i++) {
			pricePerProduct[i]=price[i]*Integer.parseInt(args[i]);
			String result=(product[i] + " : "+price[i]+"원 : "+args[i]+"개 - "+ product[i]+"총가격 : "+pricePerProduct[i]);
			System.out.println(result);
			totalPrice += pricePerProduct[i];
		}
		System.out.println("총 지불 가격은 "+ totalPrice+" 원 입니다.");
		System.out.println("선택하신 지불 수단은 명령행매개변수 5번째 입력값 " +args[4] +"입니다.");
		
		if(args.length==6) {//카드 입력시 길이 5, 현금 입력시 길이 6
			System.out.println("현금영수증 처리 번호는 " +args[5] +"입니다.");
		}
		
		String s1="java";
		String s2="java";
		String s3 = new String("java");
		String s4 = new String("java");
		System.out.println("s1 == s2 결과 "+(s1==s2)); //연산자 우선순위 () 해줘야함. 
		System.out.println("s3 == s4 결과 "+(s3==s4));
		System.out.println("s3.equlas s4 결과 "+s3.equals(s4));
	}

}
