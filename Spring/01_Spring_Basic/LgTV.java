package spring.tv;

public class LgTV implements TV{
	public void powerOn() {
		System.out.println("엘지tv-전원켜다.");
	}
	public void powerOff() {
		System.out.println("엘지tv-전원끄다.");
	}
	public void volumUp(int v) {
		System.out.println("엘지tv"+v+"만큼 볼륨 높이다.");
	}
	public void volumDown(int v) {
		System.out.println("엘지tv"+v+"만큼 볼륨 낮추다.");
	}
}
