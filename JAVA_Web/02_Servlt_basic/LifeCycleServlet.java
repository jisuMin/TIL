package life;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class LifeCycleServlet extends HttpServlet {
	// 서버 시작후 현재서블릿 최초 1번 호출 실행
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 실행(수정)");
	}
	//서버 시작후 현재서블릿 메모리 삭제 시점 실행(서블릿 코드 수정 -재컴파일 - 수정 이전 클래스 메모리 삭제 - 서버 재시작
	public void destroy() {
		System.out.println("destroy 실행");
	}
	// 서버 시작후 현재서블릿 여러번 호출시마다 실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doGet 실행");//서버 콘솔 출력(요청 브라우저 출력x)
		response.getWriter().println("<h1>lifecycle</h1>");
	}

}
