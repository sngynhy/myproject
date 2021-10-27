package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.userboard.BoardDAO;
import model.userboard.UserBoardVO;

public class MainController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDAO bDAO = new BoardDAO();
		UserBoardVO bVO = new UserBoardVO();
		
		List<UserBoardVO> datas = bDAO.getBoardList(bVO); // 게시글 전체 조회
		request.setAttribute("datas", datas);
		
		return "main";
	}
}
