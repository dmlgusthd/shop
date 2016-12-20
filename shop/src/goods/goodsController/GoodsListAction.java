package goods.goodsController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goods.service.Goods;
import goods.service.GoodsDao;

public class GoodsListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GoodListAction");
		ActionForward forward = new ActionForward();
		int currentPage =0;
		int pagePerRow  = 12;
		if(request.getParameter("currentPage")!=null){
		currentPage  = Integer.parseInt(request.getParameter("currentPage"));
		}
		GoodsDao dao = new GoodsDao();
		ArrayList<Goods> arr = dao.List(currentPage,pagePerRow);
		System.out.println("페이지 가져오기");
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("arr", arr);
		
		forward.setPath("/goods/goodslist.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
