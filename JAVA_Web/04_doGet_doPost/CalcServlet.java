package process;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Calc")
public class CalcServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		System.out.println(request.getMethod());
		System.out.println(request.getRemoteAddr());
		
		String user = request.getParameter("user");
		System.out.println(user);
		
		String su1_str = request.getParameter("su1");
		String su2_str = request.getParameter("su2");		
		
		if(su1_str == null || su1_str.equals("")|| su2_str == null || su2_str.equals("") ) {
			out.println("<h1><a href='calc.html'>다시 입력하기 </a></h1>");
		}
		else {
		//String 으로 넘어오는 값들을 연산을 위해 정수로 변환해준다.
		int su1 = Integer.parseInt(su1_str);
		int su2 = Integer.parseInt(su2_str);

		String op = request.getParameter("op");
		String result ="";
		if(op.equals("+")) {
			result = su1 + op + su2 + "=" + (su1+su2);
		}else if(op.equals("-")) {
			result = su1 + op + su2 + "=" + (su1-su2);			
		}else if(op.equals("*")) {
			result = su1 + op + su2 + "=" + (su1*su2);			
		}else if(op.equals("/")) {
			result = su1 + op + su2 + "=" + (su1/su2);			
		}else if(op.equals("%")){
			result = su1 + op + su2 + "=" + (su1%su2);	
		}else {
			result="지원되지 않는 연산자입니다.";
		}
		
		
		out.println("<h1>"+result+"</h1>");
		}
		
	}
}
