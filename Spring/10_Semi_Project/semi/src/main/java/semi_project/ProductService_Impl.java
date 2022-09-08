package semi_project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductService_Impl implements ProductService {

	
	@Autowired
	ProductDAO dao;
	
	@Autowired
	CommentDAO cdao;

	
	@Override
	public int getTotalBoard() {
		
		return dao.getCount();
	}

	@Override
	public List<ProductDTO> pagingList(int limit) {
		
		return dao.paginglist(limit);
	}

	@Override
	public int getSearchBoard(ProductDTO dto) {
		
		return dao.getCount2(dto);
	}

	@Override
	public List<ProductDTO> searchList(ProductDTO dto) {

		return dao.searchlist(dto);
	}
	// 메인페이지,검색
	
	@Override
	public ProductDTO listDetail(int seq) {
		return dao.listDetail(seq);
		
	}
	
	@Override
	public List<CommentDTO> commentlist(int seq) {
		return cdao.commentlist(seq);
	}

	@Override
	public int commentinsert(CommentDTO dto, int seq) {
		
		return cdao.commentinsert(dto, seq);
	}
	// 상세페이지 , 검색
	
	@Override
	public ProductDTO detail(int product_seq) {
		return dao.detail(product_seq);
	}
	
	@Override
	public int pulluptime(int product_seq) {
		return dao.pulluptime(product_seq);		
	}
	// 끌어올리기
	
	@Override
	public void productdelete(int seq) {
		dao.productdelete(seq);	
	}
	// 게시글 삭제

	public void updateProduct(ProductDTO dto) {
		dao.updateProduct(dto);
	}
	// 게시글 수정
	
	@Override
	public List<ProductDTO> pagingMyList(String id) {
		
		return dao.pagingmylist(id);
	}
	// 마이페이지
	
	@Override
	public int registerProduct(ProductDTO dto) {
		return dao.insertBoard(dto);
	}
	
	
}
