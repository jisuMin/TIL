package jdbc2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class PreparedSelectTest {

	public static void main(String[] args) {
		Connection con = null;
		// 설치한 mysql driver 호출 
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 호출 완료");
		//1.db 연결
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb","emp2","emp2");
		System.out.println("db 연결 성공");
	
		String query = "select id, "
				+ "insert(password, 1, length(password), repeat('*', length(password))) 암호, "
				+ "name, phone, email, "
				+" date_format(regdate, '%y/%m/%d %h시%i분%s초') 가입일 from member";
		PreparedStatement st = con.prepareStatement(query);
		ResultSet rs= st.executeQuery();
		while(rs.next()) {
			System.out.println("============================================");
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));
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
