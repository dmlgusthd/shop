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
	<form action="<c:url value='/MemberUpdate?m_id=${member.m_id}'/>" method="post">
		<table class="table" border ="1" style="width:400px">
			<tr>
				<td>���̵�</td>
				<td>
					<input type="text" name="m_id" value = "${member.m_id}" readonly/>
				</td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td>
					<input type="password" name="m_pw"/>
				</td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td>
					<input type="text" name="m_name" value = "${member.m_name}"/>
				</td>
			</tr>
			<tr>
				<td>����ó</td>
				<td>
					<input type="text" name="m_phone" value = "${member.m_phone}"/>
				</td>
			</tr>
			<tr>
				<td>�ּ�</td>
				<td>
					<input type="text" name="m_addr" value = "${member.m_addr}"/>
				</td>
			</tr>
		</table>
		<input type="submit" value="����" />
		<input type="button" onclick ="location.href='<c:url value='/MemberDetail?m_id=${member.m_id}'/>'" value="���"/>
    </form>
</div>