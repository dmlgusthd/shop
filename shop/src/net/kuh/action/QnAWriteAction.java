package net.kuh.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.kuh.db.QDAO;
import net.kuh.db.QnaDTO;
import net.member.db.Member;


@WebServlet("/qna/QnAWrite")
public class QnAWriteAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QDAO qdao = new QDAO();
		String m_id = request.getParameter("m_id");
		Member member = qdao.selectMname(m_id);
		request.setAttribute("member", member);
		
		request.getRequestDispatcher("/QnA/QnAWrite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		
		String q_category = request.getParameter("q_category");
		String q_title = request.getParameter("q_title");
		String q_detail = request.getParameter("q_detail");
		String m_name = request.getParameter("m_name");
		
		QnaDTO qnadto = new QnaDTO();
		qnadto.setQ_category(q_category);
		qnadto.setQ_title(q_title);
		qnadto.setQ_detail(q_detail);
		qnadto.setM_name(m_name);
		
		QDAO dao = new QDAO();
		dao.insertQna(qnadto);
		
		response.sendRedirect("QnAList");
	}

}
