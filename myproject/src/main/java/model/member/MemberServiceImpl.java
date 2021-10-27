package model.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SpringMemberDAO memberDAO;
	
	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}
	@Override
	public boolean checkID(String id) {
		return memberDAO.checkID(id);
	}
	@Override
	public MemberVO login(MemberVO vo) {
		return memberDAO.login(vo);
	}
	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}
	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	}
}