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
<title>답변 게시판</title>
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
				<th scope="col" class="text-center">제목</th>
				<th scope="col" class="text-center">글쓴이</th>
				<th scope="col" class="text-center">작성일</th>
				<th scope="col" class="text-center">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list}">
				<c:choose>
					<c:when test="${newIdx != list.q_idx }">
						<input type="hidden" ${newIdx = list.q_idx }>
						<tr>
							<td style="width: 60%"><a class="text-reset" href="#">
									${list.q_subject } </a></td>
							<td style="width: 10%" class="text-center">${(fn:contains(list.id, 'admin')) ? '관리자' : list.id }</td>
							<td style="width: 20%" class="text-center">${list.q_regdate }</td>
							<td style="width: 10%" class="text-center">${list.q_cnt }</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td style="width: 60%"><a class="text-reset" href="#"> └
									re: ${list.q_subject } </a></td>
							<td style="width: 10%" class="text-center">${(fn:contains(list.id, 'admin')) ? '관리자' : list.id }</td>
							<td style="width: 20%" class="text-center">${list.q_regdate }</td>
							<td style="width: 10%" class="text-center">${list.a_cnt }</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tbody>
	</table>
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
			<c:forEach var="a" begin="1" end="${pageIndex }" step="1">
				<li class="page-item"><a class="page-link" href="#">${a}</a></li>
			</c:forEach>
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
	<nav class="navbar navbar-light bg-light">
		<form action="/board/boardWriter" method="post">
			<input type="hidden" name="bdGroup" value="-1"> <input
				type="hidden" name="bdOrder" value="0"> <input type="hidden"
				name="bdIndent" value="0">
			<button type="submit" class="btn btn-secondary mb-3">새글쓰기</button>
		</form>
		<form class="form-inline">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</nav>
	<script type="text/javascript" src="/resource/js/bootstrap.js"></script>
</body>
<%@ include file="/include/footer.jsp"%>
</html>