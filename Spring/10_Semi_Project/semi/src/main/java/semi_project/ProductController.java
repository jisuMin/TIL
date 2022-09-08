package semi_project;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/listdetail")
	public ModelAndView listDetail(int seq) {
		ProductDTO dto = service.listDetail(seq);
		List<CommentDTO> commentlist = service.commentlist(seq);
		ModelAndView mv = new ModelAndView();
		mv.addObject("detail", dto);
		mv.addObject("comment",commentlist);
		mv.setViewName("semi_project/listdetail");
		return mv;
	}
	
	@PostMapping("/listdetail")
	public ModelAndView commentisnert(CommentDTO dto,int seq) {
		ProductDTO Pdto = service.listDetail(seq);
		service.commentinsert(dto,seq);	
		List<CommentDTO> commentlist = service.commentlist(seq);
		ModelAndView mv = new ModelAndView();
		mv.addObject("detail", Pdto);
		mv.addObject("comment",commentlist);
		mv.setViewName("semi_project/listdetail");
		return mv;
	}
	// 상세페이지,댓글
	
	
	@GetMapping("/pulluptime")
	public String pulluptime(int seq) {
		int result = service.pulluptime(seq);
		return "redirect:/MainMenu";
	}
	// 끌어올리기


	@RequestMapping("/productdelete")
	public String deleteBoard(int seq) {
		service.productdelete(seq);
		return "redirect:/MainMenu"; 
	}
	// 게시글 삭제
	
	
	@GetMapping("/productupdate")
	public ModelAndView updateBoard(int seq) {
		ProductDTO dto = service.listDetail(seq);
		ModelAndView mv = new ModelAndView();
		mv.addObject("update", dto);
		mv.setViewName("semi_project/updateform");
		return mv;
	}
	
	@PostMapping("/productupdate")
	public String updateBoard(ProductDTO dto) throws IllegalStateException, IOException {
		service.updateProduct(dto);
		return "redirect:/MainMenu";
	}
	// 게시글 수정
	
	@GetMapping("/productwrite")
	public String writingform() {
		return "semi_project/writingform";
	}
	
	@PostMapping("/productwrite")
	public String writingprocess(ProductDTO dto) {
		service.registerProduct(dto);
		return "redirect:/MainMenu";
	}
	// 게시글 작성
	
}
