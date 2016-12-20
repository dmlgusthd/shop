<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "goods.service.Goods" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "../module/top.jsp" %>
<%@ include file = "../module/goodsleft.jsp" %>
<%
	System.out.println("list.jsp");
	int currentPage = (int)request.getAttribute("currentPage");
	System.out.println("페이지받음"+currentPage);
	if(request.getAttribute("arr")==null){
		System.out.println("배열없음");
	}
	ArrayList<Goods> arr = (ArrayList<Goods>)request.getAttribute("arr");
	System.out.println("배열받음"+arr.size());
%>
	</br></br>
	<div class="col-sm-10text-left"> 
		<h1>상품목록</h1>
		<hr>
	</div>
    <div class="container">

        <div class="row">

<%
		for(int i =0 ; i<arr.size() ; i++){
			Goods g = arr.get(i); 
%>
            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                <a class="thumbnail" href="<%=request.getContextPath()%>/GoodsList.gc?goodsCode=<%=g.getgCode()%>">
                    <img style = "width:280px;height:170px" class="img-responsive" src="<%=g.getgImgsrc()%>" alt="">
                </a>
                <center><%=g.getgName() %></center>
            </div>
<%
		}
%>
           
            </div>
        </div>
	<hr>
</body>
</html>