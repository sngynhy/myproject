package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.member.MemberDAO;

public class CheckIDController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		
		MemberDAO mDAO = new MemberDAO();

		if (id == null || id == "") { // 입력값이 없는 경우
			out.println("null");
		} else {
			out.println(mDAO.checkID(request.getParameter("id")));
		}
		return "signup";
	}
}
