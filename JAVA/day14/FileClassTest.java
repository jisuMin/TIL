package chap18;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FileClassTest {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		File f = new File(name);
		if(f.exists()) { //파일이 존재하면 true
			System.out.println("존재합니다");
			if(f.isFile()) {//파일일 때 
				System.out.println("파일크기(byte) = "+f.length());
				System.out.println("전체경로 = " +f.getCanonicalPath());
				System.out.println("파일 읽기여부 = "+f.canRead());
				System.out.println("파일 쓰기여부 = "+f.canWrite());
				long time = f.lastModified();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E, a hh:mm:ss");
				String timeString = sdf.format(time);
				System.out.println("최종 수정시각 = "+timeString);
			}//end if file
			else {//디렉토리
				String [] details = f.list();
				System.out.println("========================");
				for(String d : details) {
					System.out.println(d);
				}
			}System.out.println("==================");
		}
		else {
			System.out.println(name + "이름의 파일이나 디렉토리는 없음.");
			//f.createNewFile();
			//System.out.println(f.createNewFile());//true => 파일 만들어짐 
			System.out.println(f.mkdir());
		}
	}

}
///chap18/src/chap18/FileClassTest.java => src부터 작성