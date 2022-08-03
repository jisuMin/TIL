package chap3;
///
public class PrimeNumberTest {

	public static void main(String[] args) {
		
		/*int su=13, cnt=0;
		
		
		for ( int i=1;i<=13;i++) {
			if(su%i==0) {
				cnt++;
			}
		}*/
		 
		//1-100까지 수 중 소수 판별 
		/*int num,count,i;

		for(num=2 ; num<=100 ; num++){
			count=0;
			for(i=2 ; i<num; i++) {
				if(num%i==0) { // 1과 정수 사이의 숫자 중 하나라도 나눈 나머지가 0일때는 소수가 아니다.
					count+=1; 
					}			
				}//end for i
			if(count==0) { // count가 올라갔다면 소수가 아니다
				System.out.println(num+"는 소수입니다.");
			}
		}//end for num */
		
		int begin = Integer.parseInt(args[0]);
		int end=Integer.parseInt(args[1]);
		int count,i;
		for(int num= begin; num<=100 ; num++){
			count=0;
			for(i=2 ; i<num; i++) {
				if(num%i==0) { // 1과 정수 사이의 숫자 중 하나라도 나눈 나머지가 0일때는 소수가 아니다.
					count+=1; 
					}			
				}//end for i
			if(count==0) { // count가 올라갔다면 소수가 아니다
				System.out.println(num+"는 소수입니다.");
			}
		}//end for num
	
	    
		/*for ( int i=2;i<13;i++) { 2-12까지 반복 : 자기 자신과 1을 뺐을 땐 cnt가 0이여야 소수 
			if(su%i==0) {
				cnt++;
			}
		}
		if(cnt==0) {
			System.out.println(su + " : 소수이다.");
		}
		else {
			System.out.println(su+" : 합성수이다.");
		}*/
		
			
	}


}