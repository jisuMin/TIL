package chap15;

class MusicThread extends Thread {
	String name;
	public MusicThread(String music) {
		this.name = music;
	}
	public void run() { //thread 상속 시 run 메소드 필수 
		for (int i=1;i<=3;i++) {
			System.out.println(name+"듣는 중입니다.");
		}
	//상속 . 생성자. 오버라이딩 - 음악듣는중입니다 3번 출력
	}
}

class DownloadThread extends Thread {
	String name;
	public DownloadThread(String down) {
		this.name=down;
	}
	public void run() { //thread 상속 시 run 메소드 필수 
		for (int i=1;i<=10;i++) {
			System.out.println(name+" 중입니다.");
		}
}
}

class NewsThread extends Thread {
	String name;
	public NewsThread(String news) {
		this.name=news;
	}
	public void run() { //thread 상속 시 run 메소드 필수 
		for (int i=1;i<=5;i++) {
			System.out.println(name+"보는 중입니다.");
		}
}
}

public class MyThreadTest {
	public static void main(String[] args) {
		Thread arr[] = new Thread[3]; //class A extends Thread 
		arr[0] = new MusicThread("음악");
		arr[1] = new NewsThread("뉴스");
		arr[2] = new DownloadThread("다운로드");
		arr[0].start();
		arr[1].start();
		arr[2].start();
		/*3개 스레드 실행 시작 메소드 호출 */
		
		/* 음악듣는중입니다
		 * 음악듣는중입니다
		 * 음악듣는중입니다
		 * 다운로드중입니다
		 * 뉴스보는 중입니다
		 * 음악듣는중입니다
		 * 음악듣는중입니다
		 * ....
		 * 
		 *   */
		
		
	}

}

