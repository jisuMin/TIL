package semi_project;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {

	@Autowired
	SqlSession session;
	
	public List<CommentDTO> commentlist(int seq) {
		return session.selectList("commentlist",seq);
	}
	
	public int	commentinsert(CommentDTO dto,int seq) {
		return session.insert("commentinsert", dto); 
	}
}
