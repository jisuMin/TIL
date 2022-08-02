package chap15;

import java.util.ArrayList;

public class ForTest {

	public static void main(String[] args) {
		//arr 5개 문자열 저장 선언 - 고정 크기 , 나중에 추가하지 못함 
		String [] arr = {"java","db","web","ai","web server"};
		//arr[5]="spring";
		arr[4]="spring"; // 존재하는 인덱스는 교체
		for ( int i=0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		//jdk 1.5버전 이후 반복문
		for(String s:arr) {
			System.out.println(s);
		}
		System.out.println("======================================");
		ArrayList<String> list = new ArrayList<String>(5); // 크기가 모자르면 자동으로 늘어남
		list.add("java");
		list.add("db");
		list.add("web");
		list.add("ai");
		list.add("web server");
		list.add("spring");
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		for(String s:list) {
			System.out.println(s.toUpperCase());
			//System.out.println(o);
		}

	}

}
