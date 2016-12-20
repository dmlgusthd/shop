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
		System.out.println("-----Controller.java Start 컨트롤러 시작  -----");
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 //요청온 주소에서 contextPath만큼 자른 문자열로 요청 판단
		 System.out.println("	요청 : "+command);
		 Action action=null;
		 ActionForward forward=null;
		 
		 
		 if(command.equals("/GoodsAddAction.gc")){
			 action = new GoodsAddAction();
			 forward = action.execute(request, response);

		 }else if(command.equals("/GoodsList.gc")){
			 action = new GoodsListAction();
			 forward = action.execute(request, response);
		 }

		 System.out.println("단위테스트 db연결종료후 컨트롤러로 이동");
		 System.out.println(forward.getPath());
			if(action != null){
				if(forward.isRedirect()){
					response.sendRedirect(forward.getPath());
				}else{
					RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getPath());
					System.out.println(forward.getPath() + "<--- mforward.getPath()[jsp 이동경로]  BoardFrontController.java");
					System.out.println();
					dispatcher.forward(request, response);
				}
			}

		
	}

}
