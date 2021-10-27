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
		
		if (mDAO.login(mVO) != null) { // �α��� ����
			HttpSession session = request.getSession();
			session.setAttribute("sessionID", mVO.getId());
			
			// jsp�� �̵��ϴ� ��� .jsp ���� -> VR(ViewResolver)�� ��θ� Ȯ�� �� .do�� ������ .jsp�� �ڵ����� �ٿ��ش�.
			return "main.do";
			
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�α��� ����!');</script>");
			return "index";
		}
	}
}
