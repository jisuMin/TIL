package chap10;

public class ExceptionTest {

	public static void main(String[] args) {
		int j=0;
		try{
			int i = Integer.parseInt(args[0]);
			j= Integer.parseInt(args[1]);
			System.out.println(i/j);	
			
		}
		catch(ArithmeticException e) {
			System.out.println("0 입력하지 마세요. -> 하위 에러처리 먼저 선언 ");
		}
		catch(Exception e) {//모든 예외에 대해 동일 처리 블록 한 개 
			System.out.println("그 밖에 예외 처리");
		}
		finally {
			System.out.println("항상 출력");
		}
		/*catch(ArithmeticException e){
			//오류가 발생되면 여기 문장 실행
			System.out.println("0은 입력하지 마세요.");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("2개 이상의 값을 입력하세요.");
		}
		catch(NumberFormatException e) {
			System.out.println("정수 변환 가능값을 입력하세요.");
		}*/
		
		System.out.println("메인완료");
	}

}
