package mybatis2;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberMain {

	public static void main(String[] args) throws IOException {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();// 설정파일 읽을 준비 
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis2/mybatis-config.xml"));// 설정파일을 읽어서 실행
		//db연결
		SqlSession session = factory.openSession(true); //mybatis-config.xml 정보에 따라 connection 생성 
		
		MemberDAO dao = new MemberDAO();
		dao.setSession(session);
				
		MemberServiceImpl service = new MemberServiceImpl();
		service.setDao(dao);
		/*List<MemberDTO> list = service.memberlist();
		
		for(int i=0;i<list.size()-1;i++) {
			System.out.println(list.get(i));
		}*/
		
		//특정 멤버 조회 - 키보드 id 입력 값 
		/*Scanner key = new Scanner(System.in);
		System.out.print("조회할 회원의 id 입력하세요. =>");
		String id = key.next(); //id 읽어옴 
			List<MemberDTO> list2 = service.oneMember(id);
		for(MemberDTO dto:list2) {
			System.out.println(dto.getId()+":"+dto.getName());
		}*/
		/*System.out.println("====================================");
		//페이징처리 
		int [] limit= {0,4};
		List<MemberDTO> list3 = service.paginglist(limit);
		for(MemberDTO dto : list3) {
			System.out.println(dto);
		}
		
		System.out.println("====================================");*/
		
		//insert 
		MemberDTO insertdto = new MemberDTO();
		insertdto.setId("mybatis");
		insertdto.setPassword(1111);
		insertdto.setName("바티스");
		insertdto.setPhone("01011111111");
		insertdto.setEmail("mybatis@batis");
		int result = service.registerMember(insertdto);
		System.out.println(result);
		
		//update
		Scanner key = new Scanner(System.in);
		System.out.print("수정할 아이디를 입력하세요. =>");
		String id = key.next(); 
		System.out.print("수정할 회원의 정보 (컬럼값 = 변경값) 입력하세요. => ");
		String updateInform = key.next();
		List<MemberDTO> selectlist = service.oneMember(id);
		
		MemberDTO updatedto = new MemberDTO();
		updatedto.setId(id);
		String colName= updateInform.split("=")[0];
		String colValue = updateInform.split("=")[1];
		
		if(colName.equals("name")) {
			updatedto.setName(colValue);
			updatedto.setEmail(selectlist.get(0).getEmail());
			updatedto.setPhone(selectlist.get(0).getPhone());
		}else if(colName.equals("email")) {
			updatedto.setEmail(colValue);
			updatedto.setName(selectlist.get(0).getName());
			updatedto.setPhone(selectlist.get(0).getPhone());
		}
		else if(colName.equals("phone")) {
			updatedto.setPhone(colValue);
			updatedto.setName(selectlist.get(0).getName());
			updatedto.setEmail(selectlist.get(0).getEmail());
		}
		
		int result2 = service.updateMember(updatedto);
		System.out.println(result2);
		
		
		//delete
		Scanner key2 = new Scanner(System.in);
		System.out.print("삭제할 아이디를 입력하세요. =>");
		String id2 = key2.next(); 
		int reuslt= service.deleteMember(id2);
		if(result==0) {
			System.out.println("가입내역이 없습니다.");
		}else {
			System.out.println("삭제되었습니다.");
		}
	}//end main

}
