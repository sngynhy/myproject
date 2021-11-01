package controller.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.area.AreaService;
import model.area.AreaVO;
import model.category.CategoryService;
import model.category.CategoryVO;
import model.nation.NationService;
import model.nation.NationVO;
import model.userboard.UserBoardService;
import model.userboard.UserBoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private UserBoardService boardService;
	@Autowired
	private CategoryService categoryService; // 교통, 숙소, 맛집 등
	@Autowired
	private NationService nationService; // 파리, 영국, 이탈리아 등
	@Autowired
	private AreaService areaService; // 유럽, 아시아 등
	
	@ModelAttribute("sidebarData")
	public Model getSideBarData(Model model) {
		List<CategoryVO> cateData = categoryService.getCategoryList();
		System.out.println(cateData);
		model.addAttribute("cateData", cateData);
		List<NationVO> nationData = nationService.getNavtionList();
		model.addAttribute("nationData", nationData);
		List<AreaVO> areaData = areaService.getAreaList();
		model.addAttribute("areaDate", areaData);
		return model;
	}
	
	@RequestMapping("/main.do")
	public String main(Model model) {
//		getSideBarData(model);
		return "main.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(UserBoardVO vo, Model model) throws Exception {
		
		List<UserBoardVO> datas = boardService.getBoardList(vo); // 게시글 전체 조회
		model.addAttribute("datas", datas); // 정보 저장 - setAttribute의 역할
		model.addAttribute("b_type", vo.getB_type());
		model.addAttribute("cate_id", vo.getCate_id());
		model.addAttribute("n_id", vo.getN_id());
//		model = getSideBarData(model);
		
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(UserBoardVO vo, Model model) {
		model.addAttribute("data", boardService.getBoard(vo));
		return "readBoard.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(UserBoardVO vo, Model model) {
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do?b_type=" + vo.getB_type() + "&cate_id=" + vo.getCate_id() + "&a_id=" + vo.getA_id() + "&n_id=" + vo.getN_id();
	}
	
	@RequestMapping("/insertBoardTry.do")
	public String insertTry(UserBoardVO vo, Model model) {
		model.addAttribute("data", vo);
		return "insertBoard.jsp";
	}
	
	@RequestMapping("/updateboardtry.do")
	public String updateTry(UserBoardVO vo, Model model) {
		model.addAttribute("data", boardService.getBoard(vo));
		return "updateBoard.jsp";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(UserBoardVO vo, Model model) {
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do?b_type=" + vo.getB_type() + "&cate_id=" + vo.getCate_id() + "&a_id=" + vo.getA_id() + "&n_id=" + vo.getN_id();
	}
	
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(UserBoardVO vo, Model model) throws IOException {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do?b_type=" + vo.getB_type() + "&cate_id=" + vo.getCate_id() + "&a_id=" + vo.getA_id() + "&n_id=" + vo.getN_id();
	}
}
