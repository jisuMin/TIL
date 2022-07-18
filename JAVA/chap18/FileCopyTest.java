package chap18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		String inputfile ="src/chap18/FileClassTest.java";
		String outputfile ="b.txt";
		//입력파일 존재 x => 예외 발생
		//입력파일 존재 o, 출력파일 존재 x => 출력파일 empty 파일 생성 출력
		//입력파일 존재 o, 출력파일 존재 o => 기본 실행 출력 파일 기존 저장 내용 삭제
		//매개변수 true -> 기본 저장 내용 유지, 추가 출력 
		try {
			fr=new FileReader(inputfile);
			fw=new FileWriter(outputfile,true);
			while(true) {
			int result = fr.read();
			if(result == -1) {
				break;
			}
			fw.write(result);
		}
		}
		catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
			fr.close();
			fw.close();
			}catch(IOException e) {}
		}

	}

}
