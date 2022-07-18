package chap15;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		Employee e1 = new Employee(100, "이사원",56000.77);
		map.put("사원1", e1);
		map.put("사원2", new Employee(200, "박사원",66000.77));
		map.put("사원3", new Employee(300, "김사원",76000.77));
		map.put("사원1", new Employee(400, "최사원",76000.77)); 
		//map에서는 키 중복 데이터 저장시 원래 데이터가 없어지고 새로운 데이터로 대체됨
		map.put("사원4", e1); // 값 중복이라 허용 
		
		System.out.println("갯수 : "+map.size());
		
		Object o = map.get("사원3");
		if(o instanceof Employee) {
			System.out.println( ((Employee)o).name);
			
		}
		//모든 데이터 조회
		Set keys = map.keySet(); //map의 키만 모으면 set이 됨 
		for(Object m : keys) {
			System.out.println("키는 "+m+"이고, 값은 "+map.get(m)); //키만 출력 
		}
	}

}
