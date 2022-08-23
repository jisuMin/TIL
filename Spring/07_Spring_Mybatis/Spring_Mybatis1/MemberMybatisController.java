package spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberMybatisController {

	@Autowired
	MemberService service;
	
	@RequestMapping("/membermybatislist")
	public ModelAndView memberlist() {
		List<MemberDTO> memberlist = service.memberlist();
		System.out.println(memberlist.size());
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist",memberlist);
		mv.setViewName("mybatis/memberlist");
		return mv;
	}

	@RequestMapping("/membermybatispaginglist")
	public ModelAndView memberlist(@RequestParam(value="page", required=false, defaultValue="1") int page) { //parameter 값이 없으면 1 
		int totalmember = service.getTotalMember(); //페이지 생성 총 갯수 
		//현재 페이지의 4개만 조회 
		List<MemberDTO> memberlist = service.paginglist(new int[] {(page-1)*4,4});
		System.out.println(memberlist.size());
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist",memberlist);
		mv.addObject("totalmember",totalmember);
		mv.setViewName("mybatis/memberpaginglist");
		return mv;
	}
	
	@RequestMapping("/membermybatissearchlist")
	public ModelAndView memberlist(String item, String searchword) {
		MemberDTO dto = new MemberDTO();
		if(item.contains("이름")) {
			dto.setName(searchword);
		}else if(item.contains("이메일")) {
			dto.setName(searchword);
		}else if(item.contains("폰번호")) {
			dto.setPhone(searchword);
		}else if(item.contains("아이디")) {
			dto.setId(searchword);
		}
		List<MemberDTO> memberlist = service.searchlist(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist",memberlist);
		mv.setViewName("mybatis/memberlist"); //2개 컨드롤러 메소드가 한 개의 뷰 공유 
		return mv;
	}

}
