<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	table a{
		display: block;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<h1>LIST <small>PAGE</small></h1>
	<table class="table table-striped table-bordered table-hover">
		<tr class="info">
			<th>사번</th>
			<th>이름</th>
			<th>날짜</th>
			<th>금액</th>
		</tr>
		<c:forEach items="${alist }" var="bean">
		<tr>
			<td><a href="detail.do?idx=${bean.sabun }">${bean.sabun }</a></td>
			<td><a href="detail.do?idx=${bean.sabun }">${bean.name }</a></td>
			<td><a href="detail.do?idx=${bean.sabun }">${bean.nalja }</a></td>
			<td><a href="detail.do?idx=${bean.sabun }">${bean.pay }</a></td>
		</tr>
		</c:forEach>
		
	</table>
	<a href="add.do"  class="btn btn-default btn-primary" role="button">input</a>
</body>
</html>










