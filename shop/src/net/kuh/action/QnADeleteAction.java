package net.kuh.action;

import java.awt.Component;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import net.kuh.db.QDAO;
import net.kuh.db.QnaDTO;


@WebServlet("/qna/QnADelete")
public class QnADeleteAction extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("QnaDeleteAction doPost메서드 실행");
		PrintWriter out = response.getWriter();
		QDAO qdao = new QDAO();
		response.setCharacterEncoding("euc-kr");
		int q_num = Integer.parseInt(request.getParameter("q_num"));
		HttpSession session = request.getSession();
		String SID = (String)session.getAttribute("SID");
		String m_id = request.getParameter("m_id");
		System.out.println("m_id is " + m_id);
		String m_name = request.getParameter("m_name");
		System.out.println("m_name is " + m_name);
		
		QnaDTO name = qdao.mNameSelectToQna(q_num);
		Object mname = name;
		String temp = "var temp = confirm('정말 삭제하시겠습니까?')";
		
		if(m_id.equals(SID)){
			response.setContentType("text/html;charset=euc-kr");
			System.out.println("if문 실행");
			out.println("<script>");
			out.println("function {");
			out.println("var temp = confirm('정말 삭제하시겠습니까?')");
			if(temp != null){
				System.out.println("확인");
				int delete = qdao.deleteQna(m_name);
				response.sendRedirect("QnAList");
			}else{
				System.out.println("취소");
			}
			out.println("}");
			out.println("</script>");
		}else if(m_id == null || m_name != mname){
			out.println("<script>");
	   		out.println("alert('권한이 없습니다.');");
	   		out.println("history.go(-1)");
	   		out.println("</script>");
	   		out.close();
		}
		
	}

}
