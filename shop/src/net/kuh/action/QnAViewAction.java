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


@WebServlet("/qna/QnAView")
public class QnAViewAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		int q_num = Integer.parseInt(request.getParameter("q_num"));
	    QDAO dao = new QDAO();
	    QnaDTO dto = dao.QnAViewDao(q_num);
	    System.out.println("QnAViewDao �޼��� ����Ϸ�");
	    request.setAttribute("dto", dto);
	    
	    HttpSession session = request.getSession();
		String SID = (String)session.getAttribute("SID");
		Member member = dao.selectMname(SID);
		request.setAttribute("member", member);
		
		
		
	    request.getRequestDispatcher("/QnA/QnAView.jsp").forward(request, response);
	    System.out.println("Dispatcher ������ �Ϸ� QnAView.jsp�� �̵�");
		
	}
}
