package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class MemberDAO {
	@Qualifier("dto1") //객체가 여러개일 때 선택
	@Autowired
	MemberDTO dto;
	
	public boolean selectMember() {
		if(dto.getId().equals("spring") && dto.getPassword()==1111) {
			return true;
		}
		else {
			return false;
		}
	}
	public void insertMember() {
		System.out.println(dto.getId() + "님 정상적으로 회원가입 되셨습니다.");
	}
	public void insertEmployee() {
		System.out.println(dto.getId()+"님 신입사원으로 입사하셨습니다.");
		
	}
	
	//컨트롤러 사용 
	public boolean selectMember(MemberDTO dto) {
		if(dto.getId().equals("spring") && dto.getPassword()==1111) {
			return true;
		}
		else {
			return false;
		}
	}
	public void insertMember(MemberDTO dto) {
		System.out.println(dto.getId() + "님 정상적으로 회원가입 되셨습니다.");
	}
	public void insertEmployee(MemberDTO dto) {
		System.out.println(dto.getId()+"님 신입사원으로 입사하셨습니다.");
		
	}
}
