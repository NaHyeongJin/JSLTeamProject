<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ include file="/include/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>글 수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
<link rel="stylesheet" href="resource/css/bootstrap.css">
<script>

</script>
</head>
<body>
<form action="/NoticeModify.do" method="post">
	<input type="hidden" name=idx value="${idx }">
	<input type="text" name="n_subject" class="form-control mt-4 mb-2"
		value="${nvo.n_subject }" required>
	<input type="text" name="n_id" class="form-control mt-4 mb-2"
		value="${nvo.id }" readonly="readonly" required>	
	<div class="form-group">
		<textarea class="form-control" rows="10" name="n_contents"
			required>${nvo.n_contents }</textarea>
	</div>
	<button type="submit" class="btn btn-secondary mb-3">수정하기</button>
</form>
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
</body>
<%@ include file="/include/footer.jsp" %> 	
</html>