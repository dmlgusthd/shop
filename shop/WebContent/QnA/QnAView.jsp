<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file = "../module/top.jsp" %>
<%@ include file = "../module/Qnaleft.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>QnA상세보기</title>
</head>
<body>
<%response.setContentType("text/html charset=euc-kr"); %>
<br><br><br>
	<form action="QnADelete" method="post">
	<label>카테고리</label>
		<select name="q_category" readonly>
			<option>${dto.q_category}</option>
		</select>
	<div><label>제목</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" style="width:70%" name="q_title" readonly value='${dto.q_title}'></div><br>
	<label>내용</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<textarea style="resize:none; width:70%" rows="20" name="q_detail" readonly>${dto.q_detail}</textarea><br>
	<center>
	<input type="hidden" value='${member.m_name}' name="m_name">
	<input type="hidden" value='${member.m_id}' name="m_id">
	<input type="hidden" value='${dto.q_num}' name="q_num">
	<input type="button" value="수정" onclick="location.href='QnAUpdate?q_num=${dto.q_num}'">
	<input type="submit" value="삭제">
	<input type="button" value="목록" onclick="location.href='QnAList'">
	</center>
	</form>
	<%
		String m_name = (String)session.getAttribute("SNAME");
		System.out.println("m_name 값 : " + m_name);
	%>
</body>
</html>