package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward2")
public class ForwardTest2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String id = request.getParameter("id");
		id = id.toUpperCase();*/
		String id = (String)request.getAttribute("upperid"); //getAttribute로 가져오는 값이 object이기 때문에 형변환 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.print(id+"회원님 반갑습니다.");
	}

}
