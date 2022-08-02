package chap10;

public class SystemClassTest {

	public static void main(String[] args) {
		System.out.println("현재시각(1/1000초 단위) = "+System.currentTimeMillis());
		System.out.println("자바 버전 = "+System.getProperty("java.version"));
		System.out.println("os = "+System.getProperty("os.name"));
		System.out.println("자바저장 디렉토리 = "+System.getProperty("user.dir"));
		System.out.println("파일분리자 = "+System.getProperty("file.separator"));

	}

}
