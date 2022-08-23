package mybatis;


import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberMain {

	public static void main(String[] args) throws IOException {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();// 설정파일 읽을 준비 
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));// 설정파일을 읽어서 실행
		//db연결
		SqlSession session = factory.openSession(); //mybatis-config.xml 정보에 따라 connection 생성 
		//sql 실행 
		List<MemberDTO> list = session.selectList("member.memberlist");
		//조회
		for(MemberDTO dto:list) {
			System.out.println(dto); //MemberDTO에 toString()이 있어 toString()으로 출력 가능 
		}//end for
		
		int count = session.selectOne("member.membercount");
		System.out.println("총 회원수 = "+count);
	}//end main

}
