package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@RequestMapping(value="/member", method=RequestMethod.GET)
	public String start() {
		return "memberhobby";
	}
	
	/*@PostMapping("/member")
	public ModelAndView end(String id,int password, int age, String[] hobby ) {
		ModelAndView mv = new ModelAndView();
		if(age>=20) {
			mv.addObject("result","성인입니다.");
		}else {
			mv.addObject("result","미성년입니다.");
		}
		mv.setViewName("memberhobbyresult");
		return mv;
	}*/
	
	@PostMapping("/member")
	public ModelAndView end(@ModelAttribute("dto") MemberHobbyDTO dto ) {
		//html입력 - dto
		ModelAndView mv = new ModelAndView();
		if(dto.getAge()>=20) {
			mv.addObject("result","성인입니다.");
		}else {
			mv.addObject("result","미성년입니다.");
		}
		mv.setViewName("memberhobbyresult");
		return mv;
	}
	
}
