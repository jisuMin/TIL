package spring.tv;

public class SamsungTV implements TV {
	public void powerOn() {
		System.out.println("삼성tv-전원켜다.");
	}
	public void powerOff() {
		System.out.println("삼성tv-전원끄다.");
	}
	public void volumUp(int i) {
		System.out.println("삼성tv"+i+"만큼 볼륨 높이다.");
	}
	public void volumDown(int i) {
		System.out.println("삼성tv"+i+"만큼 볼륨 낮추다.");
	}

}
