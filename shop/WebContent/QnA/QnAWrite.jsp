<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file = "../module/top.jsp" %>
<%@ include file = "../module/Qnaleft.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>QnA�Խ��� �۾���</title>
</head>
<body>
<br><br><br>
	<form action="QnAWrite" method="post">
	<label>ī�װ�</label>
		<select name="q_category">
			<option value="null">::����::</option>
			<option>�Ҹ�</option>
			<option>A/S</option>
			<option>��ǰ/ȯ��</option>
		</select>
	<div><label>����</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" style="width:70%" name="q_title"></div><br>
	<label>����</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<textarea style="resize:none; width:70%" rows="20" name="q_detail"></textarea><br>
	<center>
	<input type="submit" value="���">
	<input type="button" value="���" onclick="location.href='QnAList'">
	</center>
	</form>
	

</body>
</html>