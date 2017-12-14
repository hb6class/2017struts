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
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	var result=false;
	$(function() {
		$('form').submit(function() {
			return result;
		});
		$('button').eq(0).hide();
		$('button').eq(1).click(function() {
			$('button').eq(0).show();
			$('button').eq(1).hide();
			$('button').eq(2).hide();
			result=true;
			$('h1').html("UPDATE <small>PAGE</small>");
			$('input').eq(1).prop('readonly',false);
			$('input').eq(3).prop('readonly',false);
		});
	});

</script>
</head>
<body>
	<h1>DETAIL <small>PAGE</small> </h1>
	<form action="update.do" method="post">
	<div class="form-group">
		<label for="sabun" class="control-label">sabun</label>
		<input type="text" value="${bean.sabun }" name="sabun" id="sabun"  class="form-control" placeholder="sabun" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="name" class="control-label">name</label>
		<input type="text" value="${bean.name }" name="name" id="name"  class="form-control" placeholder="name" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="nalja" class="control-label">nalja</label>
		<input type="date" value="${bean.nalja }" name="nalja" id="nalja"  class="form-control" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="pay" class="control-label">pay</label>
		<input type="text" value="${bean.pay }" name="pay" id="pay"  class="form-control" placeholder="pay" readonly="readonly">
	</div>
	<button type="submit" class="btn btn-default">Submit</button>
	</form>
	<button type="button" class="btn btn-default">수정</button>
	<button type="button" class="btn btn-default">삭제</button>
</body>
</html>