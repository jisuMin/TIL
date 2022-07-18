package chap18;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputTest {

	public static void main(String[] args) {
		FileOutputStream fo = null;
		try {
			//출력 파일 존재 o =>  false / 없음 =>기존파일 내용 삭제됨, 새로운 내용 write
			//출력 파일 존재 o => true => 기존 파일 내용 유지 - 아래에 추가 write 
			//출력 파일 존재 x => 파일 자동 생성, write
			
			fo = new FileOutputStream("src/chap18/a.java",true);
			fo.write(66);
			fo.write(98);
			fo.write(13);
			fo.write('B');
			fo.write('b');
			fo.write('\n');
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}//end catch
		finally {
			try {
				fo.close(); //반드시 수행해야 함, os에게 반남하는 과정
			}catch(IOException e) {
				
			}
			 
		}
		}

}
