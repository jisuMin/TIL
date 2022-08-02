package chap15;

import java.util.HashSet;
import java.util.Iterator;

public class HashsetTest {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add(100);
		set.add(3.14);
		set.add("SetTest");
		set.add(new Employee(100,"이사원",56000.11));
		//boolean b = set.remove(100);
		//System.out.println(b);
		System.out.println("갯수 : "+set.size());
		System.out.println("셋 데이터 존재 여부 : "+set.isEmpty() ); //false => 데이터 존
		System.out.println("100이 존재하는지의 여부 : "+set.contains(100));
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}//end while
		System.out.println("=====================================");
		for ( Object o : set) {
			System.out.println(o);
		}
	}

}
