<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>DETAIL PAGE</h1>
	<table>
		<tr>
			<td>sabun</td>
			<td>${bean.sabun }</td>
		</tr>
		<tr>
			<td>name</td>
			<td>${bean.name }</td>
		</tr>
		<tr>
			<td>nalja</td>
			<td>${bean.nalja }</td>
		</tr>
		<tr>
			<td>pay</td>
			<td>${bean.pay }</td>
		</tr>
		<tr>
			<td colspan="2">
			<form action="edit.action">
				<input type="hidden" name="idx" value="${bean.sabun }">
				<button>수정</button>
			</form>
			<%-- <a href="edit.action?idx=${bean.sabun }">[수정]</a> --%>
			<a href="del.action?idx=${bean.sabun }">[삭제]</a>
			</td>
		</tr>
	</table>
</body>
</html>