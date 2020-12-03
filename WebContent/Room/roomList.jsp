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
<title>자료실</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.js"></script>
<link rel="stylesheet" href="/resource/css/bootstrap.css">
<script>
	
</script>
</head>
<body>
	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col" class="text-center">번호</th>
				<th scope="col" class="text-center">제목</th>
				<th scope="col" class="text-center">글쓴이</th>
				<th scope="col" class="text-center">작성일</th>
				<th scope="col" class="text-center">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list }">
				<tr><td colspan="5" align="center">등록된 자료가 없습니다</td></tr>
			</c:if>
			<c:forEach var="room" items="${list}">
						<tr>
							<td style="width: 10%" class="text-center">${room.r_idx }</td>
							<td style="width: 50%">
							<a class="text-reset" href="roomview?r_idx=${room.r_idx }">${room.r_subject }</a></td>
							<td style="width: 10%" class="text-center">${(fn:contains(room.r_id, 'admin')) ? '관리자' : room.r_id }</td>
							<td style="width: 20%" class="text-center">${room.r_regdate.substring(0,10) }</td>
							<td style="width: 10%" class="text-center">${room.r_cnt }</td>
						</tr>
			</c:forEach>
		</tbody>
	</table>
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="room?page=${page-1}"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
			<c:forEach var="a" begin="1" end="${totpage }" step="1">
				<li class="page-item"><a class="page-link" href="room?page=${a}">${a}</a></li>
			</c:forEach>
			<li class="page-item"><a class="page-link" href="room?page=${page+1}"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
	<nav class="navbar navbar-light bg-light">
		<%-- <c:if test="${!fn:contains(loginedMemberId, 'admin')}"> --%>
			<form>
				<button type="button" class="btn btn-secondary mb-3"
					onClick="location.href='Room/roomWrite.jsp'">새글쓰기</button>
			</form>
		<%-- </c:if> --%>
		<form name = "search" class="form-inline" action="qna_board?page=1" method="post">
			<select name="inputSearch" class="form-control">
				<option selected>제목</option>
				<option>작성자</option>
			</select>
			<input class="form-control mr-sm-2" type="search" name="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="button"
				onClick="send()">Search</button>
		</form>
	</nav>
	<script type="text/javascript" src="/resource/js/bootstrap.js"></script>
</body>
<%@ include file="/include/footer.jsp"%>
</html>