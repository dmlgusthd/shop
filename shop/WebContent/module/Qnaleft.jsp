<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
 <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/simple-sidebar.css" />
</head>
<body>

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Start Bootstrap
                    </a>
                </li>
                <li>
                    <a href="<c:url value='/QnA/FAQView.jsp'/>">FAQ</a>
                </li>
                <li>
                    <a href="<c:url value='/qna/QnAList'/>">QnA</a>
                </li>
                <li>
                    <a href="#">1:1문의</a>
                </li>
            </ul>
        </div>
</body>
</html>
