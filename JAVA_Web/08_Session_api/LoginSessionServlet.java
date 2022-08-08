package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginsession")
public class LoginSessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//id, pw 입력 - 세션 객체로 생성 - 응답 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		// 브라우저에서 최초 요청인 경우 -해당 클라이언트의 세션 객체 생성(저장 정보x), 클라이언트에게 세션id 부여
		session.setAttribute("sessionid", id);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(id != null && pw !=null) {
			out.println("<h1>로그인하셨습니다</h1>");
			out.println("<h1>사용 가능 메뉴는 다음과 같습니다.</h1>");
			out.println("<ul><li><a href=mypage> 내정보확인하러 가기 </a></li>");
			out.println("<li><a href=boardwriting> 글쓰러 가기 </a></li>");
			out.println("<li><a href=logout> 로그아웃하러 가기 </a></li></ul>");
		}else {
			out.print("<h1>로그인하신 적이 없습니다.</h1>");
		}
		
	}

}
