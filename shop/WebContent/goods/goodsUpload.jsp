<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "../module/top.jsp" %>
	<%@ include file = "../module/goodsleft.jsp" %>
	</br></br>
	<div class="col-sm-10text-left"> 
		<h1>상품 등록</h1>
		<hr>
	</div>
	<div class="well" style = "width: 600px">
	<form class="form-horizontal" style = "width:100%" method = "post" enctype = "multipart/form-data" action = "../GoodsAddAction.gc" >
		<fieldset>
		
   			<div class="form-group">
      			<label for="inputEmail" class="col-lg-2 control-label">상품명</label>
      			<div class="col-lg-10">
        			<input name = "gName" type="text" class="form-control">
      			</div>
    		</div>
    		
   			<div class="form-group">
      			<label for="inputEmail" class="col-lg-2 control-label">가격</label>
      			<div class="col-lg-10">
        			<input name = "gPrice" type="text" class="form-control">
      			</div>
    		</div>
      		
   			<div class="form-group">
      			<label for="inputEmail" class="col-lg-2 control-label">재고</label>
      			<div class="col-lg-10">
        			<input name = "gStock" type="text" class="form-control">
      			</div>
    		</div>
   			<div class="form-group">
      			<label for="inputEmail" class="col-lg-2 control-label">색상</label>
      			<div class="col-lg-10">
        			<input name = "gColor" type="text" class="form-control">
      			</div>
    		</div>
    		   			<div class="form-group">
      			<label for="inputEmail" class="col-lg-2 control-label">카테고리</label>
      			<div class="col-lg-10">
        			<input name = "gCategory" type="text" class="form-control">
      			</div>
    		</div>
   			<div class="form-group">
      			<label for="inputimg1" class="col-lg-2 control-label">이미지</label>
      			<div class="col-lg-10">
        			<input name = "gImgsrc" type="file" class="form-control">
      			</div>
    		</div>
   			<div class="form-group">
      			<label for="inputimg2" class="col-lg-2 control-label">썸네일</label>
      			<div class="col-lg-10">
        			<input name = "gThumb" type="file" class="form-control">
      			</div>
    		</div>   

		    <div class="form-group">
		      <div class="col-lg-10 col-lg-offset-2">
		        <button type="reset" class="btn btn-default">Cancel</button>
		        <button type="submit" class="btn btn-primary">Submit</button>
		      </div>
		    </div>
        		 		    		    		      		
  		</fieldset>
	</form>
	</div>
</body>
</html>