package process;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;


@WebServlet("/InsertDB")
public class InsertDBServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		String output ="";
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(Integer.parseInt(pw));
		dto.setName(name);
		dto.setPhone(phone);
		dto.setEmail(email);
		MemberDAO dao = new MemberDAO();
		// pk가 설정되어 있지 않아 같은 id의 레코드 여러 생성 가능 -> 중복검사로 해결하기 
		int condition = dao.selectMember(id, pw);
		if(condition ==3) { 
			int rows = dao.insertMember(dto);
			if(rows ==1 ) {
				output = "<h1>정상적으로 회원가입 되었습니다. <a href='logindb.html'>로그인 하러가기</a></h1>";
			}
		}// end if
		else {
			output = "<h1>아이디 중복<a href='insertdb.html'>다시 가입하러 가기</a></h1>";
		}
		o.println(output);
	}// end doPost

}
