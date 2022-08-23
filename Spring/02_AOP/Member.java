package aop1;

public class Member {
	public void login(String id) {
		//시간측정
		System.out.println(id+"님 로그인하셨습니다.");
	}
	public void logout() {
		System.out.println("로그아웃 하셨습니다.");
	}
}


