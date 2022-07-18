

import java.text.SimpleDateFormat;
import java.util.Date;


class MySum {
    int first;
    int second;
    
    MySum (int first, int second){
        this.first = first;
        this.second = second;
        
    }

     /* 조건1 - toString */
    public String toString() {
  	  return String.valueOf(first + second); //valueof = String -> int
   }
    /* 조건2 - equals  */
    public boolean equals(Object obj) { //equals는 obj를 배개변수로 함.자바 모든 클래스 타입 객체는 obj로 전달 가능 
 	   if (obj instanceof MySum) { // 
 		   /*String me = this.toString(); //현재 객체 toString
 		    * String other = obj.toString(); 전달 객체의 toString
 		    * boolean result =  me.equals(other); //String equals (문자열 내용 비교)
 		    * if( result == true){
 		    * 	return true; }
 		    * */
 		   return toString().equals(obj.toString()); 
 		   /*int result = first + second;
     	   int result2 = ((MySum) obj).first + ((MySum) obj).second;
     	   boolean b = (result == result2);
     	   return b;*/
     	  } else {
     	   return false;
     	  }
      } 	
   

   public String createTime() {
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초");
	   String result = sdf.format(new Date());
	   return result;
	   
   }
}


public class OverridingTest {

	public static void main(String[] args) {
		 int i = 10;
	        int j = 20;
	        
	        MySum ms1 = new MySum(i, j);
	        MySum ms2 = new MySum(j, i);

	        
	        System.out.println(ms1);//30
	        System.out.println(ms2);//30
		
	        if(ms1.equals(ms2)) {
			System.out.println("ms1과 ms2의 합계는 동일합니다.");
		}

		String s1 = new String("30");
	        if(ms1.equals(s1)) {
			System.out.println("ms1과 s1은  동일합니다.");
		}

		System.out.println("ms1 객체를 출력한 시각은 " + ms1.createTime() + " 입니다.");

	}

}
