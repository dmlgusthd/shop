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

<form action ="<c:url value='/MemberDelete'/>" method="post">
	<input type="hidden" name ="m_id" value="${member.m_id}"/>
	<div>
		비밀번호 : <input type="password" name ="m_pw" />
	</div>
	<div>
		<input type="submit" value="확인"/>
		<input type="reset" value="초기화"/>
	</div>
</form>