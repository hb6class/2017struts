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
	<h1>INSERT PAGE</h1>
	<form action="insert.action">
		<p>
			<label for="name">name</label>
			<input type="text" name="name" id="name" value="${name }"/>
			${fieldErrors.nameErr }
		</p>
		<p>
			<label for="pay">pay</label>
			<input type="text" name="pay" id="pay" value="${pay }" />
			${fieldErrors.payErr }
		</p>
		<p>
			<button type="submit">입력</button>
		</p>
	</form>
</body>
</html>