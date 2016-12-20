package goods.goodsController;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



@WebServlet("/GoodsController")
@MultipartConfig
public class GoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GoodsController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			doProcess(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("-----Controller.java Start ��Ʈ�ѷ� ����  -----");
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 //��û�� �ּҿ��� contextPath��ŭ �ڸ� ���ڿ��� ��û �Ǵ�
		 System.out.println("	��û : "+command);
		 Action action=null;
		 ActionForward forward=null;
		 
		 
		 if(command.equals("/GoodsAddAction.gc")){
			 action = new GoodsAddAction();
			 forward = action.execute(request, response);

		 }else if(command.equals("/GoodsList.gc")){
			 action = new GoodsListAction();
			 forward = action.execute(request, response);
		 }

		 System.out.println("�����׽�Ʈ db���������� ��Ʈ�ѷ��� �̵�");
		 System.out.println(forward.getPath());
			if(action != null){
				if(forward.isRedirect()){
					response.sendRedirect(forward.getPath());
				}else{
					RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getPath());
					System.out.println(forward.getPath() + "<--- mforward.getPath()[jsp �̵����]  BoardFrontController.java");
					System.out.println();
					dispatcher.forward(request, response);
				}
			}

		
	}

}
