package chap18;

import java.io.IOException;

public class KeyboardTest {

	public static void main(String[] args) {
		try {
		while(true) {
			int result = System.in.read();
			System.out.println(result + " : "+(char)result);			
			if(result ==13) {break;}
		}
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
