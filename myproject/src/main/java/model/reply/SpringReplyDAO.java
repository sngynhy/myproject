package model.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringReplyDAO {
	// 飘罚黎记 贸府 1. insert/delete 贸府 -> userBoard俊 update 贸府
	private String insertSQL = "INSERT INTO REPLY (B_ID, ID, CONTENT) VALUE (?,?,?)";
	private String deleteSQL = "DELETE FROM REPLY WHERE R_ID = ?";
	private String updateBoardSQL = "UPDATE USERBOARD SET R_CNT = R_CNT ? 1 WHERE B_ID = ?";
	private String updateSQL = "UPDATE REPLY SET CONTENT = ? WHERE R_ID = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertReply(ReplyVO vo) { ////// 飘罚黎记 贸府 鞘夸
		jdbcTemplate.update(insertSQL, vo.getB_id(), vo.getId(), vo.getContent());
		jdbcTemplate.update(updateBoardSQL, "+", vo.getB_id());
	}
	public void deleteReply(ReplyVO vo) { ////// 飘罚黎记 贸府 鞘夸
		jdbcTemplate.update(deleteSQL, vo.getB_id());
		jdbcTemplate.update(updateBoardSQL, "-", vo.getB_id());
	}
	public void updateReply(ReplyVO vo) {
		jdbcTemplate.update(updateSQL, vo.getContent(), vo.getR_id());
	}
}
