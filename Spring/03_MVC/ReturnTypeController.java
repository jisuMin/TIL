package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnTypeController {
	@RequestMapping("/a")
	public ModelAndView a() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("model","a메소드 호출결과");
		mv.setViewName("aa");
		return mv;
	}
	@RequestMapping("/b")
	public String b() {
		return "bb";
	}
	
	@RequestMapping("/c")
	public void cc() {
		//모델 없으면 뷰 이름 "자동"으로 mapping url
	}
	
	@RequestMapping("/d")
	public String d() {
		return "aa"; //한 개의 jsp를 여러번 호출 가능 
	}
	
	@RequestMapping("/e")
	public String e() {
		return "redirect:/a";//현재 매핑 url이 /a인 메소드 호출 = a메소드호출 
	}
}
