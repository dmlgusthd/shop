<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>FAQ</title>
</head>
<body>
<%@ include file = "../module/top.jsp" %>
<%@ include file = "../module/Qnaleft.jsp" %>
<br><br>
<div class="container">
	<h1>FAQ</h1>
	<p>�����ϴ� ����</p>
	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion" href="#collapse1">1. ȸ��Ż��� ��� �ϳ���?</a>
				</h4>
			</div>
			<div id="collapse1" class="panel-collapse collapse in">
				<div class="panel-body">�ѹ� �� �� ������</div>
			</div>
		</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse2">2. ���Ȯ���� ��� �ϳ���?</a>
			</h4>
	</div>
		<div id="collapse2" class="panel-collapse collapse">
			<div class="panel-body">�۽��..</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse3">3. AS������ ��� �ǳ���?</a>
			</h4>
		</div>
		<div id="collapse3" class="panel-collapse collapse">
			<div class="panel-body">���翡 ��ȭ�ϼ���</div>
		</div>
		</div>
	</div> 
</div>
    
</body>
</html>
