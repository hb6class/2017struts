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
	<h1>EDIT PAGE</h1>
	<form action="update.action">
		<p>
			<label for="sabun">sabun</label>
			<input type="text" name="sabun" id="sabun" value="${bean.sabun }" readonly="readonly"/>
		</p>
		<p>
			<label for="name">name</label>
			<input type="text" name="name" id="name" value="${bean.name }"/>
		</p>
		<p>
			<label for="nalja">nalja</label>
			<input type="text" name="nalja" id="nalja" value="${bean.nalja }" disabled="disabled"/>
		</p>
		<p>
			<label for="pay">pay</label>
			<input type="text" name="pay" id="pay" value="${bean.pay }"/>
		</p>
		<p>
			<button type="submit">수정</button>
		</p>
	</form>
</body>
</html>