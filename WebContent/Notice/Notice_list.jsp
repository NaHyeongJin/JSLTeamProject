<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/include/header.jsp"%>
<%request.setCharacterEncoding("utf-8"); 
String grade = request.getParameter("grade");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>공지사항</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
<link rel="stylesheet" href="resource/css/bootstrap.css">
<script>
$(function(){
	$('#writebutton').mouseenter(function(){
		$(this).text('관리자권한');
		$(this).css('color','red');
	});
	$('#writebutton').mouseleave(function(){
		$(this).text('새글쓰기');
		$(this).css('color','white');
	});
	});
	
</script>
<script>
	function send(){
		if(<%=grade%>!='a'){
			alert("관리자권한");
			return false;
		}
	}
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
		<c:if test="${empty nlist }">
		<tbody>
						<tr><td style="width: 60%" colspan="4"
						align="center"><b>등록된 공지사항이 없습니다</b></td>
						</tr>
		</tbody>
		</c:if>
		<tbody>
			<c:forEach var="nlist" items="${nlist}">
						<tr>
							<td style="width: 60%"><a class="text-reset" href="/NoticeView.do?id=${nlist.id }">
									${nlist.n_subject } </a></td>
							<td style="width: 10%" class="text-center">${nlist.grade}</td>
							<td style="width: 20%" class="text-center">${nlist.n_regdate.substring(0,10)}</td>
							<td style="width: 10%" class="text-center">${nlist.n_cnt }</td>
						</tr>
						<c:set var="listcnt" value="${nlistcnt-1 }"></c:set>
			</c:forEach>
		</tbody>
	</table>
	
	<nav aria-label="Page navigation example">
		<ul class="pagination" >
		
			<li class="page-item"><a class="page-link" href="/Notice.do?page=${page-1}"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
			<c:forEach var="a" begin="1" end="${totpage }" step="1">
				<li class="page-item"><a class="page-link" href="/Notice.do?page=${a}">${a}</a></li>
			</c:forEach>
			<li class="page-item"><a class="page-link" href="/Notice.do?page=${page+1}"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
			
		</ul>
	</nav>
	
	<nav class="navbar navbar-light bg-light">
		<form action="/NoticeWrite.do">
			<c:if test="${grade=='a' }">
			<button type="submit" class="btn btn-secondary mb-3" id="writebutton" >새글쓰기</button>
			</c:if>
		</form>
		<form class="form-inline" action="/Notice.do">
			<select name="search"class="form-control">
		   <option value="n_subject"<c:if test="${search=='n_subject' }">selected</c:if>>글제목</option>
		   <option value="n_contents"<c:if test="${search=='n_contents' }">selected</c:if>>글내용</option>
			</select>
			
			<input class="form-control mr-sm-2" type="text"
				placeholder="Search" aria-label="Search" name="key" <c:if test="${key!='null' }">value='${key}' </c:if>>
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</nav>
	<script type="text/javascript" src="resource/js/bootstrap.js"></script>
</body>
<%@ include file="/include/footer.jsp"%>
</html>