package jdbc2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class PreparedSelectTest2 {

	public static void main(String[] args) {
		Connection con = null;
		// 설치한 mysql driver 호출 
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 호출 완료");
		//1.db 연결
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/empdb","emp2","emp2");
		System.out.println("db 연결 성공");
		//employees 테이블에서 사번,이름,급여,입사일 조회, 사번이 100번대
		//first_name salary hire_date employee_id
		String query = "select  employee_id,first_name, salary, hire_date"
				+ " from employees"
				+ " where employee_id between ? and ?";
				
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, 100);
		st.setInt(2, 199);
		ResultSet rs= st.executeQuery();
		while(rs.next()) {
			System.out.println("============================================");
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getDouble(3));
			System.out.println(rs.getDate(4));
		}
		rs.close();
		}catch (ClassNotFoundException e) {
			System.out.println("미설치이거나 classpath 미등록");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("db 연결 정보 확인");
			e.printStackTrace();
		}finally {
			try {
			con.close();
			System.out.println("연결 해제 성공");
			}catch (SQLException e) {}
		}
	}

}
