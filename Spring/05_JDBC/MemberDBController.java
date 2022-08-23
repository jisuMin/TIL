package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberDBController {
	@Autowired
	MemberService service;
	
	@GetMapping("/memberdbinsert")
	public void insertform() {
		//memberdvinser.jsp 폼 입력 
		//전달하고자하는 요청 정보는 없지만 url과 같은 뷰를 줌 (void)
	}
	
	@PostMapping("/memberdbinsert")
	public ModelAndView insertresult(MemberDTO dto) {
		String registerresult = service.registerMember(dto); //dao.selectMember() --> dao.insertMember()
		ModelAndView mv = new ModelAndView();
		mv.addObject("registerresult");
		mv.setViewName("memberdbresult");
		return mv;
	}
}
