package model.userboard;

import java.util.List;

public interface UserBoardService {
	void insertBoard(UserBoardVO invo);
	void updateBoard(UserBoardVO invo);
	void deleteBoard(UserBoardVO invo);
	List<UserBoardVO> getBoardList(UserBoardVO invo);
	UserBoardVO getBoard(UserBoardVO invo);
}
