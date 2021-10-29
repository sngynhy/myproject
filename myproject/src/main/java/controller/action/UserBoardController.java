package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.userboard.UserBoardService;
import model.userboard.UserBoardVO;

@Controller
public class UserBoardController {
	
	@Autowired
	private UserBoardService boardService;
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(UserBoardVO vo, Model model) throws Exception {
		List<UserBoardVO> datas = boardService.getBoardList(vo); // 게시글 전체 조회
		model.addAttribute("datas", datas); // 정보 저장 - setAttribute의 역할
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(UserBoardVO vo, Model model) {
		model.addAttribute("data", boardService.getBoard(vo));
		return "readBoard.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(UserBoardVO vo, Model model) {
//		System.out.println(vo);
		boardService.insertBoard(vo);
		return "getBoardList.do?b_type=ask";
	}
	
	@RequestMapping("/updateboardtry.do")
	public String updateTry(UserBoardVO vo, Model model) {
		model.addAttribute("data", boardService.getBoard(vo));
		return "updateBoard.jsp";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(UserBoardVO vo, Model model) {
		boardService.updateBoard(vo);
		return "getBoardList.do?b_type=ask";
	}
	
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(UserBoardVO vo, Model model) throws IOException {
		boardService.deleteBoard(vo);
		return "getBoardList.do?b_type=ask";
	}
}
