package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;
import kr.or.ddit.exception.NotFoundIdException;

public interface MemberService {
	//로그인
	void login(String id, String pwd) throws SQLException,
		NotFoundIdException, InvalidPasswordException;
	
	//멤버 한명 조회
	MemberVO getMember(String id) throws SQLException;
	
	//회원 리스트 조회
	List<MemberVO> getMemberList() throws SQLException;
//	List<MemberVO> getMemberList(Criteria cri) throws SQLException;
}
