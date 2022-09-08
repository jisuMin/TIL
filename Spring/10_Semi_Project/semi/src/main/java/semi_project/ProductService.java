package semi_project;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ProductService {
	
	public int getTotalBoard();
	public List<ProductDTO> pagingList(int limit);
	public int getSearchBoard(ProductDTO dto);
	public List<ProductDTO> searchList(ProductDTO dto);
	// 메인페이지,검색
	
	public ProductDTO listDetail(int seq);
	public List<CommentDTO> commentlist(int seq);
	public int commentinsert(CommentDTO dto,int seq);
	// 상세페이지, 댓글
	
	public int pulluptime(int product_seq);
	public ProductDTO detail(int product_seq);
	// 끌어올리기
	
	public void productdelete(int seq);
	// 게시글 삭제
	
	public void updateProduct(ProductDTO dto);
	// 게시글 수정
	
	public List<ProductDTO> pagingMyList(String id);
	// 마이페이지
	
	public int registerProduct(ProductDTO dto);
	// 게시글 작성
}
