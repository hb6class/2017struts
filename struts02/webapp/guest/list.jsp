<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    <a href="/struts02/guest/list.do" class="btn btn-primary navbar-btn">Guest02</a>
    <a href="#" class="btn btn-default navbar-btn">Login</a>
  </div>
</nav>
<div class="container-fluid">
	<h1>LIST PAGE</h1>
	<div class="list-group">
	<c:forEach items="${list }" var="bean">
	  <a href="detail.do?sabun=${bean.sabun }" class="list-group-item">
	  	<span class="badge">	
&#8361;<fmt:formatNumber value="${bean.pay }" pattern="#,###" /> </span>
	    <h4 class="list-group-item-heading">${bean.sabun }</h4>
	    <p class="list-group-item-text">
	    [<fmt:formatDate value="${bean.nalja}" pattern="yy/MM/dd"/>] ${bean.name }</p>
	  </a>
	</c:forEach>	  
	</div>
	<a href="add.do" role="button" class="btn btn-primary btn-lg btn-block">글쓰기</a>
</div>
</body>
</html>




















