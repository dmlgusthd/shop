package net.member.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberDAO;
import net.member.db.Member;


@WebServlet("/MemberUpdate")
public class MemberUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		
		String m_id = request.getParameter("m_id");
		Member member = dao.detailMember(m_id);
		
		request.setAttribute("member", member);
		request.getRequestDispatcher("/Member/MemberUpdateForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		int memberCount = 0;
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_name = request.getParameter("m_name");
		String m_phone = request.getParameter("m_phone");
		System.out.println("m_phone is " + m_phone);
		String m_addr = request.getParameter("m_addr");
		System.out.println("m_addr is " + m_addr);
		
		Member member = new Member();
		member.setM_pw(m_pw);
		member.setM_name(m_name);
		member.setM_phone(m_phone);
		member.setM_addr(m_addr);
		
		MemberDAO dao = new MemberDAO();
		memberCount = dao.updateMember(member);
		
		response.sendRedirect(request.getContextPath() + "/MemberDetail?m_id="+m_id);
	}

}
