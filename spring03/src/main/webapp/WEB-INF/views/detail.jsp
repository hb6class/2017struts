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
	<h1>상세 페이지</h1>
	<div>
		<span>사번</span>
		<span>${bean.sabun }</span>
	</div>
	<div>
		<span>이름</span>
		<span>${bean.name }</span>
	</div>
	<div>
		<span>날짜</span>
		<span>${bean.nalja }</span>
	</div>
	<div>
		<span>금액</span>
		<span>${bean.pay }</span>
	</div>
	<div>
		<a href="edit.do?sabun=${bean.sabun }">수정</a>
		<a href="delete.do?sabun=${bean.sabun }">삭제</a>
	</div>
</body>
</html>