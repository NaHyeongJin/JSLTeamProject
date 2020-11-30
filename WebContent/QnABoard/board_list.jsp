<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<c:forEach var="item" items="${list}">
				<tr>
					<td style="width: 60%"><a class="text-reset"
						href="QnaBoard/board_view?idx=${list.idx }"> ${list.q_subject } </a></td>
					<td style="width: 10%" class="text-center">${(fn:contains(list.id, 'admin')) ? '관리자' : list.id }</td>
					<td style="width: 20%" class="text-center">${list.q_regdate }</td>
					<td style="width: 10%" class="text-center">${list.cnt }</td>
				</tr>
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
		<%-- 		<tbody>

		리스트 출력
		<%
			if (list != null && paging != null) {
				for (int i = 0; i < list.length; i++) {
		%>

		<tr>
			<td style="width: 60%">
				<!-- 게시물 제목, 답글에 대한 인덴트 적용 -->
				<%
					if (list[i].getBdIndent() > 0) {
							for (int j = 0; j < list[i].getBdIndent(); j++) {
				%>
				&nbsp&nbsp&nbsp&nbsp
				<%
					}
				%>
				└ re:&nbsp
				<%
					}
				%>
				<a class="text-reset"
					href="board/requestBdCont?requestBdNum=<%=list[i].getBdNum()%>"
				> <%=list[i].getBdTitle()%></a>
			</td>
			<!-- 작성자, 작성일, 조회수 -->
			<td style="width: 10%" class="text-center"><%=list[i].getBdUserID()%></td>
			<td style="width: 20%" class="text-center"><%=list[i].getBdDate()%></td>
			<td style="width: 10%" class="text-center"><%=list[i].getBdViewCount()%></td>
		</tr>

	</tbody> --%>
	<script type="text/javascript" src="/resource/js/bootstrap.js"></script>
</body>
<%@ include file="/include/footer.jsp"%>
</html>