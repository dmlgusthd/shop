<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file = "../module/top.jsp" %>
<%@ include file = "../module/Qnaleft.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>QnAUpdate</title>
</head>
<body>
<br><br><br>
	<form action="QnAUpdate?q_num=${dto.q_num}" method="post">
	<label>카테고리</label>
		<select name="q_category">
			<option value="null">::선택::</option>
			<option>불만</option>
			<option>A/S</option>
			<option>반품/환불</option>
		</select>
	<div><label>제목</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" style="width:70%" name="q_title" value='${dto.q_title}'></div><br>
	<label>내용</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<textarea style="resize:none; width:70%" rows="20" name="q_detail">${dto.q_detail}</textarea><br>
	<center>
	<input type="submit" value="수정">
	<input type="button" value="취소" onclick="history.go(-1)">
	<input type="button" value="목록" onclick="location.href='QnAList'">
	</center>
	</form>
</body>
</html>