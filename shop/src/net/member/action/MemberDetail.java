package net.member.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.*;


@WebServlet("/MemberDetail")
public class MemberDetail extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		
		String m_id = request.getParameter("m_id");
		Member member = dao.detailMember(m_id);
		
		request.setAttribute("member", member);
		request.getRequestDispatcher("/Member/MemberDetailForm.jsp").forward(request, response);
	}

}
