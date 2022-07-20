package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberSelectView2 implements View {

	@Override
	public void input() {
		MemberDAO dao = new MemberDAO();
		int totalcount = dao.getTotalMember(); 
		int recordPerPage = 3 ; // 한 페이지에 보여줄 레코드 수 (12/5 = 2page+2레코드)
		int totalPage=0;
		if(totalcount%recordPerPage==0) {
			totalPage = totalcount/recordPerPage;
		}else {
			totalPage = totalcount/recordPerPage+1;
		}
		System.out.println(totalPage);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("페이지 번호 입력 (1-"+totalPage+" 페이지까지 가능) : ");
		String pagenum = sc.next();
		ArrayList<MemberDTO> list = null;
		if(pagenum.equals("*")) {
			list = dao.selectAllMember();
			
			}else {
				list=dao.selectPagingMember(Integer.parseInt(pagenum),recordPerPage);
			}
		
		for(MemberDTO dto:list) {
				System.out.println(dto);
		}
	}

}
