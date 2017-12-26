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
</head>
<body>
	<h1>리스트 페이지</h1>
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>날짜</th>
			<th>금액</th>
		</tr>
		<c:forEach items="${list }" var="bean">
		<tr>
			<td><a href="detail.do?sabun=${bean.sabun }">${bean.sabun }</a></td>
			<td><a href="detail.do?sabun=${bean.sabun }">${bean.name }</a></td>
			<td><a href="detail.do?sabun=${bean.sabun }">${bean.nalja }</a></td>
			<td><a href="detail.do?sabun=${bean.sabun }">${bean.pay }</a></td>
		</tr>
		</c:forEach>
	</table>
	<a href="add.do">입력</a>
</body>
</html>






