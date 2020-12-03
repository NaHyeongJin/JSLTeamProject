<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>${vo.q_subject }</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
<link rel="stylesheet" href="resource/css/bootstrap.css">
<script>
	
</script>
</head>
<body>

	<div class="container my-1">
		<div class="row">
			<table class="table">
				<thead>
					<tr class="table-active">
						<th scope="col" style="width: 60%">${vo.q_subject }<br>
						${(fn:contains(vo.id, 'admin')) ? '관리자' : vo.id }</th>
						
						<th scope="col" style="width: 40%" class="text-right">조회수 :
							${(fn:contains(vo.id, 'admin')) ? vo.a_cnt : vo.q_cnt}<br> ${vo.q_regdate }
						</th>
				</tr>
			</thead>
			
				
					
				<tbody>
					<tr>
						<td><pre>${(fn:contains(vo.id, 'admin')) ? vo.q_a : vo.q_contents}</pre></td>
					</tr>
			</tbody>
		</table>
	</div>
</div>
<nav class="navbar navbar-expand-lg">

	<%-- <c:if test="${(fn:contains(cookie.id, 'admin'))}"> --%>
  		<form action="qna_rewrite" method="get">
  			<input type="hidden" name="idx" value="${vo.q_idx }" >
			<button type="submit" class="btn btn-secondary mr-sm-2">답글쓰기</button>
		</form>
	<%-- </c:if> --%>
  		<form action="qna_edit" method="get">
  			<input type="hidden" name="idx" value="${vo.q_idx }" >
  			<input type="hidden" name="isAnswer" value="${isAnswer }" >
			<button type="submit" class="btn btn-secondary mr-sm-2">수정하기</button>
		</form>
    	<form action="qna_delete" method="get">
    		<input type="hidden" name="idx" value="${vo.q_idx }" >
  			<input type="hidden" name="isAnswer" value="${isAnswer }" >
			<button type="submit" class="btn btn-secondary mr-sm-2">삭제하기</button>
		</form>
</nav>
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
</body>
<%@ include file="/include/footer.jsp"%> 	
</html>