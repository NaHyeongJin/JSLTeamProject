<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ include file="/include/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>글 작성</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
<link rel="stylesheet" href="resource/css/bootstrap.css">
<script>

</script>
</head>
<body>
<form action="qna_edit" method="post">
	<input type="text" name="qnaTitle" class="form-control mt-4 mb-2"
		placeholder="제목을 입력해주세요." required value="${vo.q_subject}"
	>
	<input type="hidden" name="idx" value="${vo.q_idx }">
	<input type="hidden" name="isAnswer" value="${isAnswer }">
	<div class="form-group">
		<textarea class="form-control" rows="10" name="qnaContent"
			placeholder="내용을 입력해주세요" required
		>${(isAnswer) ? vo.q_a : vo.q_contents }</textarea>
	</div>
	<button type="submit" class="btn btn-secondary mb-3">제출하기</button>
</form>
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
</body>
<%@ include file="/include/footer.jsp" %> 	
</html>