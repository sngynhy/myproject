package model.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringLikeDAO {
	
	private String insertSQL = "INSERT INTO LIKES VALUE (?,?)";
	private String deleteSQL = "DELETE FROM LIKES WHERE ID = ?";
	private String updateUBoardSQL = "UPDATE ? SET LIKE_CNT = ? WHERE B_ID = ?"; // userboard or adminboard
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void isnertLike(LikeVO vo) {
		System.out.println("jdbcTemplate으로 insert");
		jdbcTemplate.update(insertSQL, vo.getB_id(), vo.getId());
	}
	public void delete(LikeVO vo) {
		System.out.println("jdbcTemplate으로 delete");
		jdbcTemplate.update(deleteSQL, vo.getId());
	}
}
