package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public MemberVO selectMemberById(SqlSession session, String id) 
			throws SQLException {
		MemberVO mv = session.selectOne("Member-Mapper."
				+ "selectMemberById", id);
		return mv;
	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session) 
			throws SQLException {
		List<MemberVO> memberList = session.selectList("Member-Mapper."
				+ "selectMemberList");
		return memberList;
	}

}
