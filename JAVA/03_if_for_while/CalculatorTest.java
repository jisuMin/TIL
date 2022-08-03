package day4_Test;
class Calculator{
	int a;
	int b;
	String c;
	
	Calculator(int num1, int num2, String operator){
		this.a=num1;
		this.b=num2;
		this.c=operator;
	}
	void print() {
		if(c == "-") {
			System.out.println(a+c+b+" = "+(a-b) );
		}else if(c == "+") {
			System.out.println(a+c+b+" = "+(a+b) );
		}else if(c == "*") {
			System.out.println(a+c+b+" = "+(a*b) );
		}else if(c == "/") {
			System.out.println(a+c+b+" = "+(a/b) );
		}else {
			System.out.println("잘못입력"); return;
		}
	
	}
}
public class CalculatorTest {

	public static void main(String[] args) {
		Calculator calc = new Calculator(100,50,"-");
		calc.print(); 
		Calculator calc2 = new Calculator(100,50,"+");
		calc2.print();
		Calculator calc3 = new Calculator(100,50,"*");
		calc3.print();
		Calculator calc4 = new Calculator(100,50,"/");
		calc4.print();
		Calculator calc5 = new Calculator(100,50,"더하기");
		calc5.print();
	}

}
