<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript">
	
	$(function() {
		 
		if('${eng }'!='Edit'){
			$('form').submit(function() {
				window.location.replace("edit.do?idx=${bean.sabun }");
				return false;
			});
		} 
		
	});

</script>
</head>
<body>
<div class="container">
	<div class="row">
  		<div class="col-md-12">
  			<img alt="logo" src="../imgs/logo.jpg"/>
  		</div>
  	</div>
	<div class="row">
  		<div class="col-md-12">
  			<ol class="breadcrumb">
			  <li><a href="../">Home</a></li>
			  <li><a href="./list.do">Guest</a></li>
			  <li class="active">${eng }</li>
			</ol>
			<div class="jumbotron">
			  <h1>${eng } page</h1>
			  <p>${kor }페이지 입니다</p>
			  <p><a class="btn btn-primary btn-lg" href="list.do" role="button">목록</a></p>
			</div>
			<div class="page-header">
			  <h1>${eng } page <small>${kor }페이지</small></h1>
			</div>
			<form action="update.do" class="form-horizontal">
			  <div class="form-group">
			    <label for="sabun" class="col-sm-2 control-label">sabun</label>
			    <div class="col-sm-10">
			      <input type="text" value="${bean.sabun }" class="form-control" name="sabun" id="sabun" placeholder="sabun" readonly="readonly">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="name" class="col-sm-2 control-label">name</label>
			    <div class="col-sm-10">
			      <input type="text" value="${bean.name }" class="form-control" name="name" id="name" placeholder="name">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="nalja" class="col-sm-2 control-label">nalja</label>
			    <div class="col-sm-10">
			      <input type="date" value="${bean.nalja }" class="form-control" id="nalja" placeholder="nalja" disabled="disabled">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="pay" class="col-sm-2 control-label">pay</label>
			    <div class="col-sm-10">
			      <input type="text" value="${bean.pay }" class="form-control" name="pay" id="pay" placeholder="pay">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">전송</button>
			    </div>
			  </div>
			</form>
  		</div>
  	</div>
	<div class="row">
  		<div class="col-md-12">
  		비트교육센터 서울시 서초구 서초동 1327-15 비트아카데미빌딩｜ 사업자등록번호 : 214-85-24928
(주)비트컴퓨터 서초지점 대표이사 : 조현정 / 문의 : 02-3486-9600 / 팩스 : 02-6007-1245
통신판매업 신고번호 : 제 서초-00098호 / 개인정보보호관리책임자 : 권도혁
Copyright (c) 비트캠프 All rights reserved.
  		</div>
  	</div>
</div>
</body>
</html>







