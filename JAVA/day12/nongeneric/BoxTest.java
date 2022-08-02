package nongeneric;

class Apple{
	String origin;
	Apple(String origin){
		this.origin=origin;
	}
}

class Paper{
	String size; //A4
	Paper(String size){
		this.size=size;
	}
}

class Box{
	Object contents; //모든 객체 

	public Object getContents() {
		return contents;
	}

	public void setContents(Object contents) {
		this.contents = contents;
	}
}

public class BoxTest {

	public static void main(String[] args) {
		//명령행 매개변수 - apple 대구
		Apple a = null;
		Paper p = null;
		if(args[0].equalsIgnoreCase("apple")) {
			a = new Apple(args[1]);
		}else if (args[0].equalsIgnoreCase("paper")) {
			p=new Paper(args[1]);
		}
		Box b1 = new Box();
		if (a != null) { //Apple 객체가 만들어졌다면
			b1.setContents(a);
		}else if (p!=null) { //Paper 객체가 만들어졌다면 
			b1.setContents(p);
		}
		
		Object o = b1.getContents();
		if(o instanceof Apple) {
			System.out.println(((Apple)o).origin);
		}else if(o instanceof Paper) {
			System.out.println(((Paper)o).size);
		}
		
	}

}
