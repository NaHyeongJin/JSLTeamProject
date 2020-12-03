<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/include/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>비밀번호 체크</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
<link rel="stylesheet" href="resource/css/bootstrap.css">
<script>
	
</script>
</head>
<body>
	<form class="form-signin" action="qna_view" method="post">
		<input type="hidden" name="idx" value="${idx}">
		<input type="hidden" name="isAnswer" value="${isAnswer}">
		<h1 class="h3 mb-3 font-weight-normal">비밀번호를 입력하세요</h1>
		<label
			for="pass" class="sr-only">Password</label>
		<input
			type="password" name="pass" class="form-control"
			placeholder="Password" required style="margin-bottom: 10px;">
		<button class="btn btn-lg btn-primary btn-block" type="submit">확인</button>
	</form>
	<script type="text/javascript" src="resource/js/bootstrap.js"></script>
</body>
<%@ include file="/include/footer.jsp"%>
</html>