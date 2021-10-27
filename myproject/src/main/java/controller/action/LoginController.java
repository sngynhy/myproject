package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Controller;
import model.member.MemberDAO;
import model.member.MemberVO;

public class LoginController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = new MemberVO();
		
		mVO.setId(request.getParameter("id"));
		mVO.setPw(request.getParameter("pw"));
		
		if (mDAO.login(mVO) != null) { // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("sessionID", mVO.getId());
			
			// jsp로 이동하는 경우 .jsp 생략 -> VR(ViewResolver)이 경로를 확인 후 .do가 없으면 .jsp를 자동으로 붙여준다.
			return "main.do";
			
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 실패!');</script>");
			return "index";
		}
	}
}
