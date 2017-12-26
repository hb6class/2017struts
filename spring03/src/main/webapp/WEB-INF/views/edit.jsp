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
	<h1>수정 페이지</h1>
	<form action="update.do" method="post">
		<div>
			<label for="sabun">sabun</label>
			<input type="text" value="${bean.sabun }" name="sabun" id="sabun" readonly="readonly" />
		</div>
		<div>
			<label for="name">name</label>
			<input type="text" value="${bean.name }" name="name" id="name" />
		</div>
		<div>
			<label for="nalja">nalja</label>
			<input type="text" value="${bean.nalja }" name="nalja" id="nalja" disabled="disabled" />
		</div>
		<div>
			<label for="pay">pay</label>
			<input type="text" value="${bean.pay }" name="pay" id="pay" />
		</div>
		<div>
			<button type="submit">수정</button>
		</div>
	</form>
</body>
</html>