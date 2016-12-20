package net.member.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.member.db.*;

@WebServlet("/MemberAdd")
public class MemberAdd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Member/MemberAddForm.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberAdd doPost메서드 실행");
		request.setCharacterEncoding("euc-kr");
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_name = request.getParameter("m_name");
		String m_phone = request.getParameter("m_phone");
		String m_addr = request.getParameter("m_addr");
		
		Member dto = new Member();
		dto.setM_id(m_id);
		dto.setM_pw(m_pw);
		dto.setM_name(m_name);
		dto.setM_phone(m_phone);
		dto.setM_addr(m_addr);
		dto.setM_level("구매자");
		
		MemberDAO dao = new MemberDAO();
		int rowCount = dao.addMember(dto);
		response.sendRedirect(request.getContextPath() +"/index.jsp");
		
	}

}
