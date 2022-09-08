package semi_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberService_Impl implements MemberService {

	
	@Autowired
	MemberDAO dao;
	
	@Autowired
	CommentDAO cdao;
	
	@Autowired
	ProductDAO pdao;
	
	@Inject
	private MemberDAO manager;

	@Override
	public List<MemberDTO> myInfo(String id) {
		
		return dao.myInfo(id);
	}

	@Override
	public List<MemberDTO> checkMember(String id) {
		return dao.checkMember(id);
	}

	@Override
	public List<MemberDTO> memberlist() {
		return dao.getList();
	}
	// 메인,검색

	@Override
	public void checkid(String id, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		out.println(manager.checkid(id));
		out.close();
	}
	// 아이디 중복 검사(AJAX)
	
	@Override
	public void checkname(String nickname, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		out.println(manager.checkname(nickname));
		out.close();
	}
	// 닉네임 중복 검사

	@Override
	public void checkemail(String email, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		out.println(manager.checkemail(email));
		out.close();
	}
	// 이메일 중복 검사(AJAX)

	@Override
	public int joinmember(MemberDTO dto, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if (dao.checkid(dto.getId()) == 1) {
			out.println("<script>");
			out.println("alert('동일한 아이디가 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else if (dao.checkemail(dto.getEmail()) == 1) {
			out.println("<script>");
			out.println("alert('동일한 이메일이 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else if (dao.checkname(dto.getNickname()) == 1) {
			out.println("<script>");
			out.println("alert('동일한 닉네임이 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else {
			manager.joinmember(dto);
			return 1;
		}
	}
	// 회원가입
}
