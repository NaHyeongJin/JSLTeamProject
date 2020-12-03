<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<script>
	function send(){
		 bool = confirm("삭제하시겠습니까?");
		if(bool){
			del.action="/NoticeDelete.do";
		}
	}
</script>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>${nvo.n_subject }</title>
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
						<th scope="col" style="width: 60%">${nvo.n_subject }<br>
						${(fn:contains(nvo.id, 'admin')) ? '관리자' : nvo.id }</th>
						
						<th scope="col" style="width: 40%" class="text-right">조회수 :
							${nvo.n_cnt}<br> ${nvo.n_regdate }
						</th>
				</tr>
			</thead>
			
				
					
				<tbody>
					<tr>
						<td><pre>${nvo.n_contents}</pre></td>
					</tr>
			</tbody>
		</table>
	</div>
</div>
<nav class="navbar navbar-expand-lg">
	<c:if test="${grade eq 'a'}">
  		<form action="/NoticeModify.do">
  			<input type="hidden" name = "id" value="${nvo.id }">
  			 <input type="hidden" name = "idx" value="${nvo.idx }">
			<button type="submit" class="btn btn-secondary mr-sm-2">수정하기</button>
		</form>
	</c:if>
  		<c:if test="${grade=='a'}">
			<form method="post" name=del>
  			<input type="hidden" name = "id" value="${nvo.id }">
  			<input type="hidden" name = "idx" value="${nvo.idx }"> 
			<button type="submit" class="btn btn-secondary mr-sm-2" onclick="send()">삭제하기</button>
			</form>
		</c:if>
</nav>
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
</body>
<%@ include file="/include/footer.jsp"%> 	
</html>