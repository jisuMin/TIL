package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;

//MEMBER 테이블에 대한 CRUD 메소드 구현 클래스
//DATA ACCESS OBJECT
public class MemberDAO {
	public int insertMember(MemberDTO dto) {
		int result = 0;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", 
					"emp2", "emp2");//emp2 계정은 모든 db 사용 권한

			String sql = "insert into member values(?,?,?,?,?, now())";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, dto.getId() );
			pt.setInt(2, dto.getPassword());
			pt.setString(3,  dto.getName());
			pt.setString(4,  dto.getPhone());
			pt.setString(5, dto.getEmail());
			result = pt.executeUpdate();
			System.out.println("(insertMember내부)삽입행의 갯수=" + result);//오류 확인 출력
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			con.close();
			}catch(SQLException e) {}
		}
		return result;
	}//insert Member
	
	public int updateMember(MemberDTO dto) {
		int result = 0;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", 
					"emp2", "emp2");//emp2 계정은 모든 db 사용 권한

			//dto.getId() , dto.getPassword != 0 , dto.getName() != null
			
			String colName = "";
			String colValue = "";
			if(dto.getPassword() != 0) {
				colName = "password";
				colValue = String.valueOf(dto.getPassword());
			}
			else if(dto.getName() != null) {
				colName = "name";
				colValue = dto.getName();
			}
			else if(dto.getPhone() != null) {
				colName = "phone";
				colValue = dto.getPhone();
			}
			else if(dto.getEmail() != null) {
				colName = "email";
				colValue = dto.getEmail();
			}
			String sql = "update member set " + colName + "=? where id=?";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, colValue );
			pt.setString(2, dto.getId() );
			result = pt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			con.close();
			}catch(SQLException e) {}
		}
		return result;
	}//update member
	
	public int deleteMember(String id, String password) {
		int result = 0;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", 
					"emp2", "emp2");//emp2 계정은 모든 db 사용 권한

			String sql1 ="select password from member where id=? "; //4
			PreparedStatement pt1 = con.prepareStatement(sql1);
			pt1.setString(1, id);
			ResultSet rs = pt1.executeQuery();
			
			boolean isPW = false;
			while(rs.next()) {
				if(password.equals(rs.getString("password"))) {
					String sql2 = "delete from member where id=? and password=?";
					PreparedStatement pt2 = con.prepareStatement(sql2);
					pt2.setString(1, id);
					pt2.setString(2,  password);
					result = pt2.executeUpdate();
					isPW = true;
				}

			}//while end
			if(isPW == false) {
				return 0;
			}
			// 삭제-0 , 삭제x-id존재x, id존재하고 암호 다른 경우
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			con.close();
			}catch(SQLException e) {}
		}
		return result;
	}//delete member

	public MemberDTO selectOneMember(String id, String password) {
		MemberDTO dto = new MemberDTO();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", 
					"emp2", "emp2");//emp2 계정은 모든 db 사용 권한

			String sql1 ="select * from member where id=? "; //4
			PreparedStatement pt1 = con.prepareStatement(sql1);
			pt1.setString(1, id);
			ResultSet rs = pt1.executeQuery();
			
			if(rs.next()) { //id가 존재하고, password가 맞다면		
				dto.setId(rs.getString("id"));		
				if(Integer.parseInt(password)== rs.getInt("password")) { 					
					dto.setId(rs.getString("password"));
					dto.setId(rs.getString("name"));
					dto.setId(rs.getString("phone"));
					dto.setId(rs.getString("email"));
					dto.setId(rs.getString("regdate"));
				}//end password
			}//end rs.next()
			// 삭제-0 , 삭제x-id존재x, id존재하고 암호 다른 경우
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			con.close();
			}catch(SQLException e) {}
		}return dto;
	
	}
	public ArrayList<MemberDTO> selectAllMember() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", 
					"emp2", "emp2");//emp2 계정은 모든 db 사용 권한

			String sql1 ="select * from member "; //4
			PreparedStatement pt1 = con.prepareStatement(sql1);
			ResultSet rs = pt1.executeQuery();
			
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			//password를 조회하더라도 set을 하지 않으면 출력하지 않을 수 있다. 
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			dto.setRegdate(rs.getString("regdate"));
			dto.setPassword(-1);
			list.add(dto);
		}//System.out.println("dao에서 확인 : "+list.size());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			con.close();
			}catch(SQLException e) {}
		}return list;
	
	}
	public ArrayList<MemberDTO> selectSearhMember(String search) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", 
					"emp2", "emp2");//emp2 계정은 모든 db 사용 권한

			String sql ="select * from member where id like? or name like ?"
					+ " or phone like ? or email like ? "; //4
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, "%"+search+"%");
			pt.setString(2, "%"+search+"%");
			pt.setString(3, "%"+search+"%");
			pt.setString(4, "%"+search+"%");
			ResultSet rs = pt.executeQuery();
			
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			//password를 조회하더라도 set을 하지 않으면 출력하지 않을 수 있다. 
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			dto.setRegdate(rs.getString("regdate"));
			dto.setPassword(-1);
			list.add(dto);
		}//System.out.println("dao에서 확인 : "+list.size());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			con.close();
			}catch(SQLException e) {}
		}return list;
	
	}
	public int getTotalMember() {
		int result=0;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", 
					"emp2", "emp2");//emp2 계정은 모든 db 사용 권한

			String sql ="select count(*) from member";
			PreparedStatement pt = con.prepareStatement(sql);			
			ResultSet rs = pt.executeQuery();
			
			rs.next();
			result=rs.getInt("count(*)");
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			con.close();
			}catch(SQLException e) {}
		}return result;
	}//get totalMember

	public ArrayList<MemberDTO> selectPagingMember(int pagenum, int recordPerpage) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", 
					"emp2", "emp2");//emp2 계정은 모든 db 사용 권한
			
			String sql ="select * from member order by regdate limit ?,?"; //4
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, (pagenum-1)*recordPerpage);//pagenum이 1일 땐 0덱스 부터 
			pt.setInt(2, recordPerpage);
			ResultSet rs = pt.executeQuery();
			
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			//password를 조회하더라도 set을 하지 않으면 출력하지 않을 수 있다. 
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			dto.setRegdate(rs.getString("regdate"));
			dto.setPassword(-1);
			list.add(dto);
		}//System.out.println("dao에서 확인 : "+list.size());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			con.close();
			}catch(SQLException e) {}
		}return list;
	}//selectPagingMember


	
  }//class end


