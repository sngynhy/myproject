package model.userboard;

import java.util.List;

public interface UserBoardService {
	void insertBoard(UserBoardVO vo);
	void updateBoard(UserBoardVO vo);
	void deleteBoard(UserBoardVO vo);
	List<UserBoardVO> getBoardList(UserBoardVO vo);
	UserBoardVO getBoard(UserBoardVO vo);
}
