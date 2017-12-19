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
	<h1>입력폼</h1>
	<form action="result.action">
	<label for="id">id</label>
	<input type="text" id="id" name="id" />${fieldErrors.id }<br/>
	<label for="pw">pw</label>
	<input type="text" id="pw" name="pw" />${fieldErrors.pw }<br/>
	<button type="submit">전송</button>
	</form>
</body>
</html>