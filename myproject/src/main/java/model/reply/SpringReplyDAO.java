package model.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringReplyDAO {
	// Ʈ����� ó�� 1. insert/delete ó�� -> userBoard�� update ó��
	private String insertSQL = "INSERT INTO REPLY (B_ID, ID, CONTENT) VALUE (?,?,?)";
	private String deleteSQL = "DELETE FROM REPLY WHERE R_ID = ?";
	private String updateBoardSQL = "UPDATE USERBOARD SET R_CNT = R_CNT ? 1 WHERE B_ID = ?";
	private String updateSQL = "UPDATE REPLY SET CONTENT = ? WHERE R_ID = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertReply(ReplyVO vo) { ////// Ʈ����� ó�� �ʿ�
		jdbcTemplate.update(insertSQL, vo.getB_id(), vo.getId(), vo.getContent());
		jdbcTemplate.update(updateBoardSQL, "+", vo.getB_id());
	}
	public void deleteReply(ReplyVO vo) { ////// Ʈ����� ó�� �ʿ�
		jdbcTemplate.update(deleteSQL, vo.getB_id());
		jdbcTemplate.update(updateBoardSQL, "-", vo.getB_id());
	}
	public void updateReply(ReplyVO vo) {
		jdbcTemplate.update(updateSQL, vo.getContent(), vo.getR_id());
	}
}
