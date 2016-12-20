package net.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.*;


@WebServlet("/MemberLogin")
public class MemberLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Member/MemberLoginForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDAO dao = new MemberDAO();
		Member member;
		String m_id = request.getParameter("m_id");
		System.out.println("m_id is " + m_id);
		String m_pw = request.getParameter("m_pw");
		System.out.println("m_pw is " + m_pw);
		member = dao.loginMember(m_id);
		if(member==null){
			response.setContentType("text/html;charset=euc-kr");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('아이디가 존재하지 않습니다.');");
	   		out.println("location.href='./MemberLogin';");
	   		out.println("</script>");
	   		out.close();
		}else if(!member.getM_pw().equals(m_pw)){
			response.setContentType("text/html;charset=euc-kr");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('비밀번호가 일치하지 않습니다.');");
	   		out.println("location.href='./MemberLogin';");
	   		out.println("</script>");
	   		out.close();
		}else{
			session.setAttribute("SID", member.getM_id());
			session.setAttribute("SLEVEL", member.getM_level());
			response.sendRedirect(request.getContextPath()+ "/index.jsp");
		}
		
	}

}
