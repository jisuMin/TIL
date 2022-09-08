package semi_project;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {

	public List<MemberDTO> myInfo(String id);
	public List<MemberDTO> memberlist();
	public List<MemberDTO> checkMember(String id);
	// 메인페이지 , 검색

	public void checkid(String id, HttpServletResponse response) throws Exception;
	public void checkemail(String email, HttpServletResponse response) throws Exception;
	public void checkname(String nickname, HttpServletResponse response) throws Exception;
	public int joinmember(MemberDTO dto, HttpServletResponse response) throws Exception;
	// 중복 확인 및 가입
}
