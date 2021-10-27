package model.userboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class UserBoardServiceImpl implements UserBoardService {
	
	@Autowired // 의존성 주입
	private SpringUserBoardDAO boardDAO;
	
	@Override
	public void insertBoard(UserBoardVO invo) {
		boardDAO.insertBoard(invo);
	}
	@Override
	public void updateBoard(UserBoardVO invo) {
		boardDAO.updateBoard(invo);
	}
	@Override
	public void deleteBoard(UserBoardVO invo) {
		boardDAO.deleteBoard(invo);
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
