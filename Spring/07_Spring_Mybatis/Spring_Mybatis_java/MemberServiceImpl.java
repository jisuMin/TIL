package mybatis2;

import java.util.List;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<MemberDTO> memberlist() {
		List<MemberDTO> list = dao.getList();
		int count=dao.getCount();
		list.add(new MemberDTO(null,count,null,null,null,null));
		return list;
	}
	
	@Override
	public List<MemberDTO> oneMember(String id) {
		return dao.oneMember(id);
	}
	
	@Override
	public List<MemberDTO> paginglist(int[] limit) {
		return dao.pagingList(limit);
	}

	@Override
	public int registerMember(MemberDTO dto) {
		// insert할 id가 존재하는지 조회 (oneMember 사용)
		List<MemberDTO> list = dao.oneMember(dto.getId());
		if(list==null || list.size()==0) {
			return dao.insertMember(dto);
		}else {
			return 0;
		}
		
	}

	@Override
	public int updateMember(MemberDTO dto) {
		List<MemberDTO> list= dao.oneMember(dto.getId());
		if(list.size() >0) {
			return dao.updateMember(dto);
		}
		else {
			return 0;
		}
	}

	@Override
	public int deleteMember(String id) {
		List<MemberDTO> list= dao.oneMember(id);
		if(list.size() >0) {
			return dao.deleteMember(id);
		}
		else {
			return 0;
		}
	}

	
	
}
