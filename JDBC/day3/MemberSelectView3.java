package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberSelectView3 implements View {

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어 입력 : ");
		String search = sc.next();
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.selectSearhMember(search);
		System.out.println("input에서 확인 : "+list.size());
		for(MemberDTO dto:list) {
			System.out.println(dto);
			
		}
	}

}
