<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file = "../module/top.jsp" %>
<%@ include file = "../module/Qnaleft.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>QnA�󼼺���</title>
</head>
<body>
<br><br><br>
	<label>ī�װ�</label>
		<select name="q_category" readonly>
			<option>${dto.q_category}</option>
		</select>
	<div><label>����</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" style="width:70%" name="q_title" readonly value='${dto.q_title}'></div><br>
	<label>����</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<textarea style="resize:none; width:70%" rows="20" name="q_detail" readonly>${dto.q_detail}</textarea><br>
	<center>
	<input type="button" value="����" onclick="location.href='QnAUpdate?q_num=${dto.q_num}'">
	<input type="button" value="����" onclick="location.href=''">
	<input type="button" value="���" onclick="location.href='QnAList'">
	</center>
</body>
</html>