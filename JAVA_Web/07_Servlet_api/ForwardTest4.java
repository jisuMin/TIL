package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;

@WebServlet("/forward4")
public class ForwardTest4 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = (MemberDTO)request.getAttribute("dto");//null
		//new MemberDTO();
		//SETiD()
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.print(dto);
	}

}
