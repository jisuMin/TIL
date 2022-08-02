package chap10;

import java.io.IOException;

public class KeyboardTest {

	public static void main(String[] args) {
		try {
			while(true) {
				
				int result = System.in.read();
				if(result==13) { break; }
				//if(result=='\n') { break; } 위아래 같은 코드(엔터치면 종료)
				System.out.println((char)result);
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
}
