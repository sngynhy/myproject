package model.userboard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.member.MemberVO;

class UserBoardRowMapper implements RowMapper<UserBoardVO> {
	@Override
	public UserBoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBoardVO vo = new UserBoardVO();
		vo.setB_id(rs.getInt("b_id"));
		vo.setId(rs.getString("id"));
		vo.setTitle(rs.getString("title"));
		vo.setContent(rs.getString("content"));
		vo.setR_cnt(rs.getInt("r_cnt"));
		vo.setLike_cnt(rs.getInt("like_cnt"));
		vo.setB_date(rs.getString("b_date"));
		vo.setB_type(rs.getString("b_type"));
		vo.setA_id(rs.getString("a_id"));
		vo.setN_id(rs.getString("n_id"));
		vo.setCate_id(rs.getString("cate_id"));
		return vo;
	}
}

public class SpringUserBoardDAO {
	
	private final String insertSQL = "INSERT INTO BOARD (B_ID, ID, TITLE, CONTENT, B_TYPE, N_ID, C_ID, CATE_ID) VALUES (USERBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
	private final String updateSQL = "UPDATE USERBOARD SET TITLE = ?, CONTENT = ?, U_DATE = SYSDATE, B_TYPE = ?, N_ID = ?, C_ID = ?, CATE_ID = ? WHERE B_ID = ?";
	private final String deleteSQL = "DELETE USERBOARD WHERE B_ID = ?"; // 트랜잭션 처리 -> LIKE 테이블 B_ID로 delete
	private final String deleteLikeSQL = "DELETE FROM LIKES WHERE B_ID = ?";
	private final String getBoardListSQL = "SELECT * FROM USERBOARD B_TYPE = ?";
	private final String getBoardSQL = "SELECT * FROM USERBOARD WHERE B_ID = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertBoard(UserBoardVO vo) {
		Object[] args = {vo.getId(), vo.getTitle(), vo.getContent(), vo.getB_type(), vo.getN_id(), vo.getC_id(), vo.getCate_id()};
		jdbcTemplate.update(insertSQL, args);
	}
	
	public void updateBoard(UserBoardVO vo) {
		Object[] args = {vo.getTitle(), vo.getContent(), vo.getB_type(), vo.getN_id(), vo.getC_id(), vo.getCate_id(), vo.getB_id()};
		jdbcTemplate.update(updateSQL, args);
	}
	
	public void deleteBoard(UserBoardVO vo) { //////////////////// 트랜잭션 처리 필요
		jdbcTemplate.update(deleteSQL, vo.getB_id());
		jdbcTemplate.update(deleteLikeSQL, vo.getB_id());
	}
	
	/*public List<UserBoardVO> getBoardList(UserBoardVO vo) {
		
		List<UserBoardVO> result = null;
		
		if (vo.getKeyword() == null) { // 게시글 전체 목록
			return jdbcTemplate.query(getBoardListSQL + " order by wdate desc", new UserBoardRowMapper());
		} else if (vo.getCondition().equals("title")) {
			Object[] args = {"%"+vo.getKeyword()+"%"};
			result = jdbcTemplate.query(getBoardListSQL + " where title like ? order by wdate desc", args, new UserBoardRowMapper());
		} else if (vo.getCondition().equals("content")) {
			Object[] args = {"%"+vo.getKeyword()+"%"};
			result = jdbcTemplate.query(getBoardListSQL + " where content like ? order by wdate desc", args, new UserBoardRowMapper());
		} else if (vo.getCondition().equals("id")) {
			Object[] args = {"%"+vo.getKeyword()+"%"};
			result = jdbcTemplate.query(getBoardListSQL + " where id like ? order by wdate desc", args, new UserBoardRowMapper());
		}
		return result;
	}*/
	
	public UserBoardVO getBoard(UserBoardVO vo) { // 사용자가 선택한 글 보기
		Object[] args = {vo.getB_id()};
		return jdbcTemplate.queryForObject(getBoardSQL, args, new UserBoardRowMapper());
	}
}
