package net.kuh.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.kuh.db.QDAO;
import net.kuh.db.QnaDTO;


@WebServlet("/qna/QnAUpdate")
public class QnAUpdateAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int q_num = Integer.parseInt(request.getParameter("q_num"));
	    QDAO dao = new QDAO();
	    QnaDTO dto = dao.QnAViewDao(q_num);
	    System.out.println("QnAViewDao �޼��� ����Ϸ�");
	    request.setAttribute("dto", dto);
	    request.getRequestDispatcher("/QnA/QnAUpdate.jsp").forward(request, response);
	    System.out.println("Dispatcher ������ �Ϸ�");
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		int q_num = Integer.parseInt(request.getParameter("q_num"));
		System.out.println("q_num ��:" + q_num);
		String q_category = request.getParameter("q_category");
		String q_title = request.getParameter("q_title");
		String q_detail = request.getParameter("q_detail");
		
		QDAO dao = new QDAO();
		QnaDTO dto = new QnaDTO();
		dto.setQ_category(q_category);
		dto.setQ_title(q_title);
		dto.setQ_detail(q_detail);
		
		dao.updateQna(dto);
		
		response.sendRedirect("QnAList?q_num="+q_num);
	}

}
