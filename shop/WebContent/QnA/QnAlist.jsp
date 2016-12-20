<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file = "../module/top.jsp" %>
<%@ include file = "../module/Qnaleft.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	th{text-align:center;}
	td{text-align:center;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>QnA</title>
</head>
<body>
<br><br>
<div class="container">
	<h1>QnA</h1>
	<p>질문과 답변</p>      
	<div><input type="button" value="글쓰기" onclick="location.href='QnAWrite?m_id=${member.m_id}'"/></div>      
	<table border=1 width="88%">
	<thead>
		<tr>
		  <th>번호</th>
		  <th>질문유형</th>
		  <th>제목</th>
		  <th>이름</th>
		  <th>날짜</th>
		</tr>
    </thead>
    <c:forEach var='q' items='${list}'>
	<tbody>
		<tr>
			<td>${q.q_num}</td>
			<td>${q.q_category}</td>
			<td><a href="QnAView?q_num=${q.q_num}">${q.q_title}</a></td>
			<td>${q.m_name}</td>
			<td>${q.q_date}</td>
		</tr>
	</tbody>
	</c:forEach>
	</table>
</div>

</body>
</html>
