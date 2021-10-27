package model.member;

public interface MemberService {
	void insertMember(MemberVO vo);
	MemberVO login(MemberVO vo);
	void updateMember(MemberVO vo);
	void deleteMember(MemberVO vo);
	boolean checkID(String id);
}
