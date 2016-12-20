package net.member.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.*;


@WebServlet("/MemberDelete")
public class MemberDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_id=request.getParameter("m_id");
		Member member = new Member();
		member.setM_id(m_id);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/Member/MemberDeleteForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberDelete doPost 메서드 실행");
		String m_id = request.getParameter("m_id");
		System.out.println("m_id is " + m_id);
		String m_pw = request.getParameter("m_pw");
		System.out.println("m_pw is " + m_pw);
		
		MemberDAO dao = new MemberDAO();
		int memberCount = dao.deleteMember(m_id, m_pw);
		
		response.sendRedirect(request.getContextPath() + "/MemberList");
	}

}
