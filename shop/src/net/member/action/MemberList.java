package net.member.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.*;


@WebServlet("/MemberList")
public class MemberList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> memberList = dao.memberList();
		
		request.setAttribute("memberList", memberList);
		request.getRequestDispatcher("/Member/MemberList.jsp").forward(request, response);
	}

}
