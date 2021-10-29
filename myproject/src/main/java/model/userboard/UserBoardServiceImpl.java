package model.userboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userboardService")
public class UserBoardServiceImpl implements UserBoardService {
	
	@Autowired // 의존성 주입
	private SpringUserBoardDAO boardDAO;
	
	@Override
	public int insertBoard(UserBoardVO invo) {
		return boardDAO.insertBoard(invo);
	}
	@Override
	public int updateBoard(UserBoardVO invo) {
		return boardDAO.updateBoard(invo);
	}
	@Override
	public int deleteBoard(UserBoardVO invo) {
		return boardDAO.deleteBoard(invo);
	}
	@Override
	public List<UserBoardVO> getBoardList(UserBoardVO invo) {
		return boardDAO.getBoardList(invo);
	}
	@Override
	public UserBoardVO getBoard(UserBoardVO invo) {
		return boardDAO.getBoard(invo);
	}
}
