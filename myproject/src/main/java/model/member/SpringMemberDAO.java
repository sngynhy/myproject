package model.member;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class MemberRowMapper implements RowMapper<MemberVO> {
	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO outvo = new MemberVO();
		outvo.setId(rs.getString("id"));
		outvo.setPw(rs.getString("pw"));
		outvo.setEmail(rs.getString("email"));
		outvo.setPhone(rs.getString("phone"));
		return outvo;
	}
}

@Repository
public class SpringMemberDAO {
	
	// 회원가입, 로그인, 정보 변경, 탈퇴, ID 중복체크
	private String insertSQL = "insert into member value (?,?,?,?)";
	private String loginSQL = "select * from member where id = ? and pw = ?";
	private String updateSQL = "update member set pw = ?, email = ?, phone = ? where id = ?";
	private String deleteSQL = "delete from ? where id = ?"; // 회원 탈퇴 시 member, reply, likes, userboard 테이블에서 해당 회원 ID 데이터 삭제
	private String checkID = "select * from member where id = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertMember(MemberVO vo) {
		jdbcTemplate.update(insertSQL, vo.getId(), vo.getPw(), vo.getEmail(), vo.getPhone());
	}
	public MemberVO getMember(MemberVO vo) {
		Object[] args = {vo.getId(), vo.getPw()};
		return jdbcTemplate.queryForObject(loginSQL, args, new MemberRowMapper());
	}
	public void updateMember(MemberVO vo) {
		jdbcTemplate.update(updateSQL, vo.getPw(), vo.getEmail(), vo.getPhone(), vo.getId());
	}
	public void deleteMember(MemberVO vo) { ////// 트랜잭션 처리 필요
		jdbcTemplate.update(deleteSQL, "member", vo.getId());
		jdbcTemplate.update(deleteSQL, "reply", vo.getId());
		jdbcTemplate.update(deleteSQL, "likes", vo.getId());
		jdbcTemplate.update(deleteSQL, "userboard", vo.getId());
	}
	public boolean checkID(String id) {
		Object[] args = {id};
		try {
			jdbcTemplate.queryForObject(checkID, args, new MemberRowMapper());
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
}
