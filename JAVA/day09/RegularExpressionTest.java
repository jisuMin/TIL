package chap10;

public class RegularExpressionTest {

	public static void main(String[] args) {
		
		/*String phones[]=
			{"010-1234-5678", "011-1234-5678","010-12345-6789","010-^^^2-5678"};
		for (int i=0; i<phones.length;i++) {
			//System.out.println( phones[i].matches("010-[0-9]{3,4}-[0-9]{4}"));
			System.out.println( phones[i].matches("(010|011)-.{3,5}-[0-9]*")); //다 true로 만드는 규칙
			System.out.println(phones[i].contains("1234"));
		}*/
		String address = "서울시-서초구/서초동 태크부루:아카데미 4층";
		String [] result = address.split("(-|/|:| )");
		//String address = "서울시.서초구.서초동.태크부루.아카데미.4층";
		//String [] result = address.split("[.]"); //특수문자 []안에 작성 : . + * ?
		System.out.println(result.length);
		for (int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}

}
