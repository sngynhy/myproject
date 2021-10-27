package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.member.MemberDAO;
import model.member.MemberVO;

public class InsertMemberController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = new MemberVO();
		
		mVO.setId(request.getParameter("id"));
		mVO.setPw(request.getParameter("pw"));
		mVO.setName(request.getParameter("name"));
		
		if (mDAO.insertMember(mVO)) {
			return "index";
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원가입 실패!');</script>");
			return "signup";
		}
	}
}
