package chap15;

import java.util.ArrayList;

class SameSentence {
	ArrayList compare(ArrayList list1, ArrayList list2){
		ArrayList result = new ArrayList();
		int len1 = list1.size();
		int len2 = list2.size();
		if(len1 == len2) {
			for(int i=0;i<len1;i++) {
				if(list1.get(i).equals(list2.get(i))) {
					result.add(list1.get(i));
				}
			}
		}
		/*if (list1.size() == list2.size()) {
			for ( int i =0; i<list1.size();i++) {
				if(list1.get(i).equals(list2.get(i))) {
					result.add(list1.get(i));
				}
			}//end for
		}// end if*/
		return result;
		
		
	}//end compare
}
public class SameSentenceTest {
public static void main(String[] args) {
	ArrayList list1 = new ArrayList();
	list1.add("자바는 객체지향 언어입니다");
	list1.add("우리는 멀티캠퍼스에서 자바를 배우는 중입니다");
	list1.add("오늘은 컬렉션 프레임워크를 배우죠! ");
	list1.add("내일은 입출력과 네트워크를 배울 예정입니다 ");
	
	ArrayList list2 = new ArrayList();
	list2.add("자바는 객체지향 언어입니다");
	list2.add("우리는 MULTI에서 자바를 배우는 중입니다");
	list2.add("오늘은 콜렉션 프레임워크를 배우죠! ");
	list2.add("내일은 입출력과 네트워크를 배울 예정입니다 ");
	
	ArrayList list3 = new ArrayList();
	list3.add("자바는 객체지향 언어입니다");
	list3.add("우리는 kitri에서 자바를 배우는 중입니다");
	list3.add("오늘은 콜렉션 프레임워크를 배우죠! ");
	
	SameSentence ss = new SameSentence();
	ArrayList result1 = ss.compare(list1, list2);
	//result1에는 list1, list2의 문자열 갯수 같고 같은 인덱스의 문자열을 비교하여 같은 문자열만 저장 ArrayList 리턴, 출력
	//구현할 것
	if(result1.size() !=0) {
		for(int i=0; i<result1.size();i++) {
			System.out.println(result1.get(i));
		}//end for
	}//end if
	else {
		System.out.println("list1의 갯수 = " +list1.size());
		System.out.println("list2의 갯수 = " +list2.size());
	}
		
	ArrayList result2 = ss.compare(list1, list3);
	//result2 list1, list3의 문자열 갯수 같지 않을 때 
	//list1의 갯수, list3 갯수 출력 구현할 것
	if(result2.size() !=0) {
		for(int i=0; i<result1.size();i++) {
			System.out.println(result1.get(i));
		}//end for
	}//end if
	else {//인덱스 0 문장은 같지만 문장 갯수가 다름
		System.out.println("list1의 갯수 = " +list1.size());
		System.out.println("list3의 갯수 = " +list3.size());
	}
		
	
}
}