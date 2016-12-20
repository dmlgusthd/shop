<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
            
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">Watch Shop</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="<%=request.getContextPath()%>/goods/goodslist.jsp">상품목록</a>
                    </li>
                    <li>
                        <a href="<%= request.getContextPath()%>/Epilogue/epiloguelist.jsp">구매후기</a>
                    </li>
                    <li>
                        <a href="<%= request.getContextPath()%>/QnA/QnAlist.jsp">고객센터</a>
                    </li>
                    
                </ul>
                 <ul class="nav navbar-nav navbar-right">
                 	<% 
                 		String SLEVEL = (String)session.getAttribute("SLEVEL");
            			String SID = (String)session.getAttribute("SID");
            		if(SID!=null){
            		%>           			
            			<li><br><%=SID%>님 환영합니다!!&nbsp;&nbsp;&nbsp;&nbsp;</li>	
              			<li><a href="<%= request.getContextPath()%>/MemberLogout"> 로그아웃</a></li>
                 	<%	
            			}else{
            		%>	
            			<li><a href="<%= request.getContextPath()%>/MemberLogin"> 로그인</a></li>
				        <li><a href="<%= request.getContextPath()%>/MemberAdd"> 회원가입</a></li>
            		<%
            			}
            		%>	
                 	
				       
				 </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>


</body>
</html>