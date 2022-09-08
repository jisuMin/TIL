package semi_project;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberDAO {

	@Autowired
	SqlSession session;
	
	
	public List<MemberDTO> myInfo(String id) {
		return session.selectList("myinfo",id);
	}
	
	public List<MemberDTO> checkMember(String id) {
		return session.selectList("myinfo",id);
	}
	
	public List<MemberDTO> getList() {
		return session.selectList("memberlist");
	}
	// 메인,검색
	
	public int checkid(String id) throws Exception{
		return session.selectOne("checkid", id);
	}
	// 아이디 중복 검사
	
	public int checkname(String nickname) throws Exception{
		return session.selectOne("checkname", nickname);
	}
	// 닉네임 중복 검사
		
	public int checkemail(String email) throws Exception{
		return session.selectOne("checkemail", email);
	}
	// 이메일 중복 검사
		
	@Transactional
	public int joinmember(MemberDTO dto) throws Exception{
		return session.insert("joinmember", dto);
	}
	// 회원가입
	
}
