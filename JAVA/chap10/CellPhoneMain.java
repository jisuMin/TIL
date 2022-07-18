package chap10;

class CellPhone{
	String model;
	double battery;

	
	public CellPhone(String model) {
		
	}
	void call(int time) throws IllegalArgumentException{
	
		
		if(time <0 ) { throw new IllegalArgumentException("통화시간 입력 오류"); }	
		System.out.println("통화시간 " + time + "분"); 
		battery -=time*0.5;
		if(battery < 0 ) {battery =0;}
	}
	void charge(int time) throws IllegalArgumentException { 
		
		
		if(time <0) {throw new IllegalArgumentException("충전시간 입력 오류"); }
		System.out.println("충전시간 : "+time);
		battery += time * 3;
		if(battery > 100) { battery=100; }
	}
	void printBattery() {
		System.out.println("남은 배터리 양 : "+ battery);
	}
	
	boolean isSame(CellPhone other) throws IllegalArgumentException {
		
		return model.equalsIgnoreCase(other.model);
		
	}
}

public class CellPhoneMain {

	public static void main(String[] args) throws IllegalArgumentException {
		CellPhone myPhone = new CellPhone("GALAXY-7");
		
			myPhone.charge( 20 ); //20분간 충전을 한다. 
			myPhone.printBattery();
			myPhone.call( 300 ); //300분간 통화를 한다.
			myPhone.printBattery();
			myPhone.charge( 50 ); //50분간 충전을 한다. 
			myPhone.printBattery();
			myPhone.call( 40 ); //40분간 통화를 한다. 
			myPhone.printBattery();
		try{	
			myPhone.call( -20 ); //통화시간입력오류
		
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		try {
			myPhone.charge(-20);
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		CellPhone yourPhone = new CellPhone("galaxy-7");
		if( myPhone.isSame(yourPhone) ) { 
			System.out.println("동일 모델입니다.");
		}
		//end if
		else {
		System.out.println("다른 모델입니다.");
		} //end else
		
	}//end main
		

}//end class


