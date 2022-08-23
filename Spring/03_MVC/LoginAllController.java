package annotation.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAllController {
	
	/*@RequestMapping("/loginform")
	//모델없고 loginform.jsp뷰 
	public String loginform() {
		return "loginform";
	}*/
	
	//test
	/*@RequestMapping("/loginresult")
	public ModelAndView loginresult(String id, int password) {
		//로그인요청 정보 입력
				LoginDTO dto = new LoginDTO();
				//모델 생성
				dto.setId(id);
				dto.setPassword(password);
				//전달
				ModelAndView mv = new ModelAndView();
				mv.addObject("loginresult", dto);
				mv.setViewName("loginresult");
				return mv;
	}*/
	
	//test3
	/*	@RequestMapping("/loginresult")
		public ModelAndView loginresult(@RequestParam("id") String name, int password) { //id란 paramd을 name에 mapping
			//로그인요청 정보 입력
					LoginDTO dto = new LoginDTO();
					//모델 생성
					dto.setId(name);
					dto.setPassword(password);
					//전달
					ModelAndView mv = new ModelAndView();
					mv.addObject("loginresult", dto);
					mv.setViewName("loginresult");
					return mv;
		}*/
		//test4
		/*	@RequestMapping("/loginresult")
			public ModelAndView loginresult(LoginDTO dto) { 
					ModelAndView mv = new ModelAndView();
					mv.addObject("loginresult", dto);
					mv.setViewName("loginresult");
					return mv;
			}*/
	
	//test5
	/*@RequestMapping("/loginresult")
	public String loginresult(@ModelAttribute("loginresult") LoginDTO dto) { 
			return "loginresult";
	}*/
	
	//test6
	//@RequestMapping(value="/login", method=RequestMethod.GET)//get방식 일 때
	@GetMapping("/login")//get방식 일 때 위랑 같은 표현 (4버전에서) 
	public String loginform() {
		return "loginform";
	}
	//@RequestMapping(value="/login", method=RequestMethod.POST)
	@PostMapping("/login")
	public String loginresult(@ModelAttribute("loginresult") LoginDTO dto) { //post 방식 일 때 
		System.out.println(dto.getId()+" : "+dto.getPassword());
		return "loginresult";
}
}
