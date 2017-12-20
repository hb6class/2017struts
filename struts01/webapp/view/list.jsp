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
	<h1>LIST PAGE</h1>
	<a href="add.action">글쓰기</a>
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>날짜</th>
			<th>금액</th>
		</tr>
		<c:forEach items="${list }" var="bean">
		<tr>
			<td>
				<a href="detail.action?idx=${bean.sabun }">${bean.sabun }</a>
			</td>
			<td>
				<a href="detail.action?idx=${bean.sabun }">${bean.name }</a>
			</td>
			<td>
				<a href="detail.action?idx=${bean.sabun }">${bean.nalja }</a>
			</td>
			<td>
				<a href="detail.action?idx=${bean.sabun }">${bean.pay }</a>
			</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>













