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
	<table class="table" border ="1" style="width:400px">
		<tr>
			<td>���̵�</td>
			<td>${member.m_id}</td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td>${member.m_name}</td>
		</tr>
		<tr>
			<td>����ó</td>
			<td>${member.m_phone}</td>
		</tr>
		<tr>
			<td>�ּ�</td>
			<td>${member.m_addr}</td>
		</tr>
		<tr>
			<td>����Ʈ</td>
			<td>0 point</td>
		</tr>
	</table>
	<input type="button" onclick ="location.href='<c:url value='/MemberUpdate?m_id=${member.m_id}'/>'" value="����"/>
    <input type="button" onclick ="location.href='<c:url value='/MemberDelete?m_id=${member.m_id}'/>'" value="����"/>
</div>