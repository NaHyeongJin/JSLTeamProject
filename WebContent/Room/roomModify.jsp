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
<form name="room" action="roommodify" method="post" enctype="multipart/form-data">
<input type="hidden" name="r_idx" value="${vo.r_idx }">
<input type="hidden" name="oldfile" value="${vo.r_filename }">
	<input type="text" name="r_subject" class="form-control mt-4 mb-2" value="${vo.r_subject }"
		placeholder="제목을 입력해주세요." required
	>
	<c:if test = "${!isLoginned}">
		<input type="text" name="r_id" class="form-control" value="${vo.r_id }"
			placeholder="아이디를 입력해주세요." readonly
		>
	</c:if>
	<div class="form-group">
		<textarea class="form-control" rows="10" name="r_contents"
			placeholder="내용을 입력해주세요" required
		>${vo.r_contents }</textarea>
		<input type="file" name="r_filename" class="form-control mt-4 mb-2">
	</div>
	<button type="submit" class="btn btn-secondary mb-3" formaction="/roommodify">제출하기</button>
</form>
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
</body>
<%@ include file="/include/footer.jsp" %> 	
</html>