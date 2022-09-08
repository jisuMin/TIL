package semi_project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberController {

	@Autowired
	MemberService service1;
	
	@Autowired
	ProductService service2;
	
	@GetMapping("/login")
	public String login() {
		return "semi_project/loginform";
	}
		
	@ResponseBody
	@PostMapping("/login")
	public String loginprocess(String id, int password , HttpServletRequest request) {

		HttpSession session = request.getSession();
		List<MemberDTO> list = service1.checkMember(id);

		if(list.size() == 0) { // ID존재하지 않음
			
			return "fail";
		}
		
		else {
			if(list.get(0).getPassword() == password) { // DB의 비밀번호와 내가 입력한 비밀번호 비교
				session.setAttribute("sessionID", id);
				session.setAttribute("sessionPASSWORD", password);
				return id;	
			}
			else {
				return "fail";
			}	
		}	
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionID") != null) {
			session.removeAttribute("sessionID");
		}
		else {
			session.setAttribute("sessionID", null);
		}
		return "semi_project/loginform";
	}
	
	@GetMapping("/MainMenu")
	public ModelAndView boardlist1(@RequestParam(value="page",required = false, defaultValue = "1") int page) {
		
		
		int totalboard = service2.getTotalBoard(); // DB에 입력된 데이터의 수
		List<ProductDTO> boardlist = service2.pagingList((page-1)*4); 
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("boardlist",boardlist);
		mv.addObject("totalboard",totalboard);
		mv.setViewName("semi_project/mainform");
		return mv;
	}
	// 로그인 한 main
	
	@GetMapping("/MainMenu2")
	public ModelAndView boardlist2(@RequestParam(value="page",required = false, defaultValue = "1") int page) {
		
		
		int totalboard = service2.getTotalBoard(); // DB에 입력된 데이터의 수
		List<ProductDTO> boardlist = service2.pagingList((page-1)*4); 
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("boardlist",boardlist);
		mv.addObject("totalboard",totalboard);
		mv.setViewName("semi_project/mainform2");
		return mv;
	}
	// 로그인 안한 main
	
	@GetMapping("/search")
	public ModelAndView boardlist3(String search, String category) {

		ProductDTO dto = new ProductDTO();
		dto.setProduct_name(search);
		dto.setProduct_category(category);
		
		int searchcount = service2.getSearchBoard(dto); // 조건에 따른 DB에 입력된 데이터의 수
		List<ProductDTO> searchlist = service2.searchList(dto); // 조건에 따른 데이터 (seq로 나열)
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("totalboard",searchcount);
		mv.addObject("boardlist",searchlist);
		mv.setViewName("semi_project/mainform");
		
		return mv;
	}
	// 로그인 한 검색
	
	@GetMapping("/search2")
	public ModelAndView boardlist4(String search, String category) {

		ProductDTO dto = new ProductDTO();
		dto.setProduct_name(search);
		dto.setProduct_category(category);
		
		int searchcount = service2.getSearchBoard(dto); // 조건에 따른 DB에 입력된 데이터의 수
		List<ProductDTO> searchlist = service2.searchList(dto); // 조건에 따른 데이터 (seq로 나열)
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("totalboard",searchcount);
		mv.addObject("boardlist",searchlist);
		mv.setViewName("semi_project/mainform2");
		
		
		return mv;
	}
	// 로그인 안한 검색
	
	@RequestMapping("/memberjoinform")
	public String memberjoinform() {
		return "semi_project/joinform";
	}
	// 회원 가입 폼

	@PostMapping("/checkid")
	public void checkid(@RequestParam("id") String id, HttpServletResponse response) throws Exception{
		service1.checkid(id, response);
	}
	// 아이디 중복 검사
	
	@PostMapping("/checkemail")
	public void checkemail(@RequestParam("email") String email, HttpServletResponse response) throws Exception{
		service1.checkemail(email, response);
	}
	// 이메일 중복 검사
	
	@PostMapping("/checkname")
		public void checkname(@RequestParam("email") String nickname, HttpServletResponse response) throws Exception{
			service1.checkname(nickname, response);
	}
	// 닉네임 중복 검사

	@PostMapping("/joinmember")
	public String joinmember(@ModelAttribute MemberDTO dto, RedirectAttributes rttr, HttpServletResponse response) throws Exception{
		rttr.addFlashAttribute("result", service1.joinmember(dto, response));
		return "redirect:/login";
	}
	// 회원 가입
	
	@GetMapping("/mypage")
	public ModelAndView mypage(String id) {

		List<ProductDTO> mylist = service2.pagingMyList(id); 
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("mylist",mylist);
		mv.setViewName("semi_project/mypage");
		return mv;
	}
	// 마이페이지
	
}

