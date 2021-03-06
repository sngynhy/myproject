package model.member;

public interface MemberService {
	int insertMember(MemberVO vo);
	MemberVO getMember(MemberVO vo);
	int updateMember(MemberVO vo);
	int deleteMember(MemberVO vo);
	boolean checkID(String id);
}
