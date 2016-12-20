package goods.goodsController;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import goods.service.Goods;
import goods.service.GoodsDao;

public class GoodsAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("euc-kr");
		System.out.println("addAction");
		ActionForward forward = new ActionForward();
		
		//파일업로드 이미지
        Part part = request.getPart("gImgsrc"); //part타입으로 업로드된 파일을 받아온다.
        String dir1 = "D:/workspace/GroupPj/WebContent/img/view/";
        String filename1 = part.getSubmittedFileName();
        part.write(dir1+filename1);
        System.out.println("이미지 업로드");
        //파일업로드 썸네일
        part = request.getPart("gThumb"); //part타입으로 업로드된 파일을 받아온다.
        String dir2 = "D:/workspace/GroupPj/WebContent/img/thumb/";
        String filename2 = part.getSubmittedFileName();
        part.write(dir2+filename1);
        System.out.println("썸네일 업로드");
        String gName = request.getParameter("gName");
        System.out.println(gName);
        int gPrice = Integer.parseInt(request.getParameter("gPrice"));
        System.out.println(gPrice);
        int gStock = Integer.parseInt(request.getParameter("gStock"));
        System.out.println(gStock);
        String gColor = request.getParameter("gColor");
        System.out.println(gColor);
        String gCategory = request.getParameter("gCategory");
        String gImgsrc = request.getContextPath()+"/img/view/"+filename1;
        System.out.println(gImgsrc);
        String gThumb = request.getContextPath()+"/img/thumb/"+filename2;
        System.out.println(gThumb);
        
        Goods g = new Goods();
        g.setgName(gName);
        g.setgPrice(gPrice);
        g.setgStock(gStock);
        g.setgColor(gColor);
        g.setgCategory(gCategory);
        g.setgImgsrc(gImgsrc);
        g.setgThumb(gThumb);
        
        GoodsDao dao = new GoodsDao();
        int resultRow = dao.addGoods(g);
        if(resultRow!=0){
        	forward.setPath(request.getContextPath()+"/index.jsp");
        	forward.setRedirect(true);
        }else{
        	forward.setPath(request.getContextPath()+"/goods/goodsUpload.jsp");
        	forward.setRedirect(true);
        }
		return forward;
	}

}
