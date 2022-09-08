package semi_project;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	
	@Autowired
	SqlSession session;
	
	public int getCount() {
		return session.selectOne("boardcount");
	}
	
	public List<ProductDTO> paginglist(int limit) {
		return session.selectList("pagingboard",limit);
	}
	
	public int getCount2(ProductDTO dto) {
		return session.selectOne("searchcount", dto);
	}
	
	public List<ProductDTO> searchlist(ProductDTO dto) {
		return session.selectList("searchboard", dto);
	}
	// 메인페이지, 검색
	
	public ProductDTO listDetail(int seq) {
		return session.selectOne("listDetail",seq);
	}
	// 상세페이지
	
	public int pulluptime(int product_seq) {
		return session.update("pulluptime", product_seq);
	}

	public ProductDTO detail(int product_seq) {
		
		return session.selectOne("detail",product_seq);
	}
	// 끌어올리기
	
	public void productdelete(int seq) {
		session.delete("productdelete",seq);
	}
	// 게시글 삭제
	
	public void updateProduct(ProductDTO dto) {
		session.update("updateProduct", dto);
	}
	// 게시글 수정
	
	public int getMyCount(String id) {
		return session.selectOne("mycount");
	}
	
	public List<ProductDTO> pagingmylist(String id) {
		return session.selectList("pagingmyboard",id);
	}
	// 마이페이지
	
	public int insertBoard(ProductDTO dto) {
		return session.insert("insertproduct", dto);
	}
	// 게시글 작성
	
	
}
