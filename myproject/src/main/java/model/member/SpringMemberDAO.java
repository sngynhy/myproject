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
	
	// ȸ������, �α���, ���� ����, Ż��, ID �ߺ�üũ
	private String insertSQL = "insert into member value (?,?,?,?)";
	private String loginSQL = "select * from member where id = ? and pw = ?";
	private String updateSQL = "update member set pw = ?, email = ?, phone = ? where id = ?";
	private String deleteSQL = "delete from member where id = ?";
	private String checkID = "select * from member where id = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertMember(MemberVO vo) {
		System.out.println("jdbcTemplate���� insert");
		jdbcTemplate.update(insertSQL, vo.getId(), vo.getPw(), vo.getEmail(), vo.getPhone());
	}
	public MemberVO login(MemberVO vo) {
		System.out.println("jdbcTemplate���� login");
		Object[] args = {vo.getId(), vo.getPw()};
		return jdbcTemplate.queryForObject(loginSQL, args, new MemberRowMapper());
	}
	public void updateMember(MemberVO vo) {
		System.out.println("jdbcTemplate���� update");
		jdbcTemplate.update(updateSQL, vo.getPw(), vo.getEmail(), vo.getPhone(), vo.getId());
	}
	public void deleteMember(MemberVO vo) {
		System.out.println("jdbcTemplate���� delete");
		jdbcTemplate.update(deleteSQL, vo.getId());
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
