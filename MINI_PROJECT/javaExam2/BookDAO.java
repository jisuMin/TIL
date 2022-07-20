package javaExam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class BookDAO {
	public void insertBook(BookDTO bookdto) {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", 
					"emp2", "emp2");
			
			String sql = "insert into book values(?,?,?,?,?,?)";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, bookdto.getBookNo() );
			pt.setString(2, bookdto.getBookTitle());
			pt.setString(3, bookdto.getBookAuthor());
			pt.setString(4, bookdto.getBookYear());
			pt.setInt(5, bookdto.getBookPrice());
			pt.setString(6, bookdto.getBookPublisher());
			pt.executeUpdate();
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}//insertBook
	
	public void selectBook() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", 
					"emp2", "emp2");

			String sql ="select bookNo, bookTitle, bookAuthor,"
					+ " date_format(bookYear,'%Y'),bookPrice,bookPublisher"
					+ " from book"; 
			PreparedStatement pt = con.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();
			System.out.println("====================================================");
		while(rs.next()) {
			System.out.print(rs.getString(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.print(rs.getString(4)+"\t");
			System.out.print(rs.getInt(5)+"\t");
			System.out.println(rs.getString(6));
		}
		System.out.println("====================================================");
		rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			con.close();
			}catch(SQLException e) {}
		}
	
	}
}
