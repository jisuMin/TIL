package priority;

class Data{ 
	int value;
	//메소드들이 run()에서 사용하는 메소드에 synchronized 선언 해야 함. 
	public synchronized void saveValue(int value) { // synchronized = DataThread1, DataThread2 중 하나가 먼저 실행 후 종료되야 나머지 실행 
		this.value=value;
		try {
			Thread.sleep(1000); // 두 번 실행됨 1이 종료 후 2가 다시 실행되기 때문에 
			//하나 나오고 2초 후 나머지 나옴 
		}catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() +" : " +this.value);
	}
}

class DataThread1 extends Thread{
	Data d;
	public DataThread1(String name, Data d) {
		super(name);
		this.d=d;
	}
	public void run() {
		d.saveValue(10);
	}
}

class DataThread2 extends Thread{
	Data d;
	public DataThread2(String name, Data d) {
		super(name);
		this.d=d;
	}
	public void run() {
		d.saveValue(20);
	}
}

public class SynchronizedTest {

	public static void main(String[] args) {
		Data d=new Data();
		DataThread1 t1 = new DataThread1("스레드1", d);
		DataThread2 t2 = new DataThread2("스레드2", d);
		t1.start();
		t2.start();
		}
	}


