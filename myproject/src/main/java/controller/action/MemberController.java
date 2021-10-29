package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.member.MemberService;
import model.member.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/login.do")
	public String login(HttpSession session, HttpServletResponse response, MemberVO vo) throws IOException {
		if (memberService.getMember(vo) != null) { // 로그인 성공
			session.setAttribute("sessionID", vo.getId());
			return "main.jsp";
		} else { // 로그인 실패
			ScriptUtils.alertAndBackPage(response, "로그인에 실패하였습니다. 아이디 혹은 비밀번호 확인 후 다시 시도하세요.");
			return "";
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "index.jsp";
	}
	
	@RequestMapping("/insertMember.do")
	public String insertMember(HttpServletResponse response, MemberVO vo) throws Exception {
		memberService.insertMember(vo);	
		return "login.jsp";
	}
	
	@RequestMapping("/checkID.do")
	public boolean checkID(@RequestParam("id") String id, HttpServletResponse response) throws Exception {
		return memberService.checkID(id);
	}
	
	@RequestMapping("/mypage.do")
	public String getMember(HttpSession session, MemberVO vo, Model model) {
		vo.setId((String) session.getAttribute("sessionID"));
		model.addAttribute("data", memberService.getMember(vo));
		return "mypage.jsp";
	}
	
	@RequestMapping("/updatetry.do")
	public String udpateTry(HttpServletResponse response, MemberVO vo, Model model) throws IOException {
		vo = memberService.getMember(vo);
		if (vo != null) {
			model.addAttribute("data", vo);
			return "updateMember.jsp";
		} else {
			ScriptUtils.alertAndBackPage(response, "비밀번호가 일치하지 않습니다.");
			return "";
		}
	}
	
	@RequestMapping("/updateMember.do")
	public String updateMember(HttpSession session, HttpServletResponse response, MemberVO vo, Model model) throws IOException {
		vo.setId((String) session.getAttribute("sessionID"));
		memberService.updateMember(vo);
		model.addAttribute("data", memberService.getMember(vo));
		return "mypage.jsp";
	}
	
	@RequestMapping("/deleteMember.do")
	public String deleteMember(HttpSession session, MemberVO vo) throws Exception {
		vo.setId((String) session.getAttribute("sessionID"));
		memberService.deleteMember(vo);
		session.invalidate();
		return "index.jsp";
	}
}
