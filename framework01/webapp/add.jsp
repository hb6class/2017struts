<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<h1>ADD <small>PAGE</small></h1>
	<form action="insert.do" method="post">
	<div class="form-group">
		<label for="sabun" class="control-label">sabun</label>
		<input type="text" name="sabun" id="sabun"  class="form-control" placeholder="sabun">
	</div>
	<div class="form-group">
		<label for="name" class="control-label">name</label>
		<input type="text" name="name" id="name"  class="form-control" placeholder="name">
	</div>
	<div class="form-group">
		<label for="nalja" class="control-label">nalja</label>
		<input type="date" name="nalja" id="nalja"  class="form-control">
	</div>
	<div class="form-group">
		<label for="pay" class="control-label">pay</label>
		<input type="text" name="pay" id="pay"  class="form-control" placeholder="pay">
	</div>
	<button type="submit" class="btn btn-default">Submit</button>
	</form>
</body>
</html>











