<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/main.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file = "../module/top.jsp" %>
<br>
<br>
<br>
<br>
<div class="container">
	<table class="table">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>등급</td>
			<td>연락처</td>
			<td>주소</td>
		</tr>
		<c:forEach var="member" items="${memberList}">
			<tr>
				<td><a href="<c:url value='/MemberDetail?m_id=${member.m_id}'/>">${member.m_id}</a></td>
				<td>${member.m_name}</td>
				<td>${member.m_level}</td>
				<td>${member.m_phone}</td>
				<td>${member.m_addr}</td>
			</tr>
		</c:forEach>
	</table>
</div>
