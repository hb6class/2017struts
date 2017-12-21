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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        비트교육센터
      </a>
    </div>
    <a href="/struts02/main.do" class="btn btn-default navbar-btn">Home</a>
    <a href="#" class="btn btn-default navbar-btn">Content</a>
    <a href="/struts02/guest/list.do"  class="btn btn-primary navbar-btn">Guest02</a>
    <a href="#" class="btn btn-default navbar-btn">Login</a>
  </div>
</nav>
<div class="container-fluid">
	<h1>DETAIL PAGE</h1>
	<form class="form-horizontal">
		  <div class="form-group">
		    <label for="sabun" class="col-sm-2 control-label">sabun</label>
		    <div class="col-sm-10">
		      <input type="text" value="${bean.sabun }" name="sabun" class="form-control" id="sabun" placeholder="sabun" readonly="readonly">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="name" class="col-sm-2 control-label">name</label>
		    <div class="col-sm-10">
		      <input type="text" value="${bean.name }" name="name" class="form-control" id="name" placeholder="name" disabled="disabled">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="nalja" class="col-sm-2 control-label">nalja</label>
		    <div class="col-sm-10">
		      <input type="datetime" value="${bean.nalja }" name="nalja" class="form-control" id="nalja" placeholder="nalja" disabled="disabled">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="pay" class="col-sm-2 control-label">pay</label>
		    <div class="col-sm-10">
		      <input type="number" value="${bean.pay }" name="pay" class="form-control" id="pay" placeholder="pay" disabled="disabled">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <a href="edit.do?sabun=${bean.sabun }" role="button" class="btn btn-primary">수정</a>
		      <a href="delete.do?sabun=${bean.sabun }" role="button" class="btn btn-danger">삭제</a>
		    </div>
		  </div>
	</form>
</div>
</body>
</html>























