package chap18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputTest {

	public static void main(String[] args) {
		FileInputStream fi =null;
		try {
		 fi= new FileInputStream("src/chap18/FileClassTest.java");
		//os에게 파일 사용 접근 허락 요청 - os 수락 
		while(true) {
			int result = fi.read();// -->여기서 예외발생하면 나머지 무시, close 안됨 
			System.out.print(result);
			if(result == -1) {break;}
		}
		
		}catch(IOException e) {
			e.printStackTrace();
		}//end catch
		finally {
			try {
				fi.close(); //반드시 수행해야 함, os에게 반남하는 과정
			}catch(IOException e) {
				
			}
			 
		}
		}

}
