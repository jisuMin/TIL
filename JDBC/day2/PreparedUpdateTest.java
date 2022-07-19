package jdbc2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedUpdateTest {

	public static void main(String[] args) {
		Connection con = null;
		// 설치한 mysql driver 호출 
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 호출 완료");
		//1.db 연결
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb","emp2","emp2");
		System.out.println("db 연결 성공");
	
		// 수정하기 
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 아이디 : ");
		String id = sc.next();
		System.out.print("수정할 이름 : ");
		String name = sc.next();
		System.out.print("수정할 폰 번호 : ");
		String phone = sc.next();
		System.out.print("수정할 이메일 : ");
		String email = sc.next();
		
		String query = "update c_member "
				+ "set name= ?,phone=?,email=?"
				+ " where id=?";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, name);
		st.setString(2, phone);
		st.setString(3, email);
		st.setString(4, id);
		int rowcount = st.executeUpdate();
		System.out.println("수정된 행의 갯수 : "+rowcount);
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

