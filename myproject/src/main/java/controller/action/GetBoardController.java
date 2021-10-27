package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.userboard.BoardDAO;
import model.userboard.UserBoardVO;

public class GetBoardController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDAO bDAO = new BoardDAO();
		UserBoardVO bVO = new UserBoardVO();
		
		bVO.setWpk(Integer.parseInt(request.getParameter("wpk")));
		
		UserBoardVO data = bDAO.getBoard(bVO);
		request.setAttribute("data", data);
		
		return "readBoard.jsp";
	}
}
