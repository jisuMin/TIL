package annotation.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import annotation.memberservice.MemberDTO;
import annotation.memberservice.MemberService;

@Controller
public class MemberServiceController {
	@Autowired
	@Qualifier("service1")
	MemberService service;//memberservice 객체가 있다면 가져와라 (여러개라면 이름이 service1인 것을 가져와라) 
	
	@RequestMapping("/memberservice")
	public ModelAndView memberservice(MemberDTO dto){ //annotation.memberservice에 있는 MemberDTO import (id,password)
		String registerresult = service.registerMember(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("registerresult",registerresult);
		mv.setViewName("memberservice");
		return mv;
	}
}
