package mybatis2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {
	
	SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public List<MemberDTO> getList(){
		return session.selectList("member2.memberlist");		
	}
	public int getCount() {
		return session.selectOne("member2.membercount");
		
	}

	public List<MemberDTO> oneMember(String id) {
		return session.selectList("onemember",id);
	}

	public List<MemberDTO> pagingList(int[] limit) {
		return session.selectList("paginglist",limit);
	}
	
	public int insertMember(MemberDTO dto) {
		return session.insert("insertmember",dto);
	}
	
	public int updateMember(MemberDTO dto) {
		return session.update("updatemember", dto);
	}
	
	public int deleteMember(String id) {
		return session.delete("deletemember",id);
	}
}
