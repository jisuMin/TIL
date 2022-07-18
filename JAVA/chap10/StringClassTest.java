package chap10;

public class StringClassTest {

	public static void main(String[] args) {
		char c[]=new char[100];
		int index=0;
		try {
			while (true) {
				int result = System.in.read();				
				if(result =='\n') { break; }
				c[index++]=(char)result;
			}//end while
			
			String sc = new String(c);
			System.out.println(sc.toUpperCase()); //키보드 입력 문자를 무조건 대문자로 출력 
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
