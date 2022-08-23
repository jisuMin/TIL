package annotation.memberservice;

public interface MemberService {
	public void registerMember();//main
	
	public String registerMember(MemberDTO dto);//컨트롤러 요청 파라미터값  = 오버로딩
	
}
