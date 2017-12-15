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
			  <li class="active">Guest</li>
			</ol>
			<div class="jumbotron">
			  <h1>List page</h1>
			  <p>목록페이지 입니다</p>
			  <p><a class="btn btn-primary btn-lg" href="add.do" role="button">글쓰기</a></p>
			</div>
			<div class="page-header">
			  <h1>List page <small>목록페이지</small></h1>
			</div>
			<table class="table">
				<tr>
					<th>사번</th>
					<th>이름</th>
					<th>날짜</th>
					<th>금액</th>
				</tr>
				<c:forEach items="${alist }" var="bean">
				<tr>
					<td><a href="#">${bean.sabun }</a></td>
					<td><a href="#">${bean.name }</a></td>
					<td><a href="#">${bean.nalja }</a></td>
					<td><a href="#">${bean.pay }</a></td>
				</tr>
				</c:forEach>
				
			</table>
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







