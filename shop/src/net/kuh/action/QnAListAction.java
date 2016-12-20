package net.kuh.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.kuh.db.QDAO;
import net.kuh.db.QnaDTO;
import net.member.db.Member;

@WebServlet("/qna/QnAList")
public class QnAListAction extends HttpServlet {
	private QDAO qdao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("QnAList doGet 메서드 실행");
		int currentPage = 1;
		if(request.getParameter("currentPage")!= null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		qdao = new QDAO();
		int totalRowCount = qdao.selectTotalBoardCount();
		int pagePerRow = 10;
		int beginRow = (currentPage-1)*pagePerRow;
		int lastPage = totalRowCount/pagePerRow;
		if(totalRowCount%pagePerRow != 0){
			lastPage++;
		}
		HttpSession session = request.getSession();
		String SID = (String)session.getAttribute("SID");
		Member member = qdao.selectMname(SID);
		
		List<QnaDTO> list = qdao.selectQnaListPerPage(beginRow, pagePerRow);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalRowCount", totalRowCount);
		request.setAttribute("pagePerRow", pagePerRow);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/QnA/QnAlist.jsp").forward(request, response);
		System.out.println("QnAList doGet 메서드 종료 QnAlist.jsp로이동");
	}

}
