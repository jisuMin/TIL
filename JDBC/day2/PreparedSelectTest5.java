package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedSelectTest5 {

	public static void main(String[] args) {
		Connection con = null;
		try {
		//0. 설치한 mysql driver 호출
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 호출 완료");
		//1. db연결
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/empdb", 
				"emp2", "emp2");//emp2 계정은 모든 db 사용 권한
		System.out.println("연결 성공");

		// 80번 부서에 근무하는 사원이름 부서이름 도시이름 조회 (join)
		/* select 사원이름, 부서이름 ,도시이름 
		 * from 사원테이블 inner join 부서테이블 on 사원테이블 부서테이블 공통컬럼 같을 때
		 * inner join 도시테이블 on 부서테이블 도시테이블 공통컬럼 같을 때 */
		String query = "select first_name, department_name, city"
				+ " from employees e join departments d on e.department_id=d.department_id "
				+ " join locations l on d.location_id = l.location_id"
				+ " where d.department_id = ?";//여러개행 db명 1개컬럼 리턴
		PreparedStatement st = con.prepareStatement(query); //(현재는 비어있는) sql저장 가능한 객체 생성
		st.setInt(1,80);
		ResultSet rs = st.executeQuery();// rs 닫혀있다
		
		int count = 0;
		while(rs.next()) {//1번레코드이동
			count++;
			System.out.println(rs.getString(1)+ "-" + rs.getString(2) + "-" + rs.getString(3));
		}
		
		System.out.println("=== 총 레코드갯수 - " + count);
		rs.close();
		Statement st2 = con.createStatement();
		ResultSet rs2 = st2.executeQuery("select count(*) from employees");
		rs2.next();
		System.out.println("=== 총 사원갯수 - " + rs2.getInt("count(*)"));
		
		}catch(ClassNotFoundException e) {
			System.out.println("미설치이거나 classpath 미등록 또는 드라이버명 오타 확인");
		}catch(SQLException e) {
			System.out.println("db연결 정보 잘못 확인");
			e.printStackTrace();
		}finally {
			//4. db연결해제
			try {
			con.close() ;// mysql 외부 연결 허용 최대치 - 100여개
			System.out.println("연결 해제 성공");
			}catch(SQLException e) { }
		}

	}

}