package jdbc2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedInsertTest {

	public static void main(String[] args) {
		Connection con = null;
		// 설치한 mysql driver 호출 
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 호출 완료");
		//1.db 연결
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb","emp2","emp2");
		System.out.println("db 연결 성공");
		//c_member 테이블에 데이터 삽입 
		// id_jdbc2 2222 김강산 010-4321-4321 kang@tech.com now()
		String sql="insert into c_member values(?,?,?,?,?,now())";
		PreparedStatement pt = con.prepareStatement(sql);
		pt.setString(1, "id_jdbc2");
		pt.setInt(2, 2222);
		pt.setString(3, "김강산");
		pt.setString(4,"010-4331-4321");
		pt.setString(5, "kang@tech.com");
		int rows = pt.executeUpdate();
		System.out.println("삽입 행의 갯수 : "+rows);
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
