package net.kuh.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.kuh.db.QDAO;
import net.kuh.db.QnaDTO;


@WebServlet("/qna/QnAView")
public class QnAViewAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int q_num = Integer.parseInt(request.getParameter("q_num"));
	    QDAO dao = new QDAO();
	    QnaDTO dto = dao.QnAViewDao(q_num);
	    System.out.println("QnAViewDao 메서드 실행완료");
	    request.setAttribute("dto", dto);
	    request.getRequestDispatcher("/QnA/QnAView.jsp").forward(request, response);
	    System.out.println("Dispatcher 포워딩 완료");
		
	}
}
