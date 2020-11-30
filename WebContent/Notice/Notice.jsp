<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>공지사항</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.js"></script>
<link rel="stylesheet" href="/resource/css/bootstrap.css">
</head>
<body>
	<div>
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
         <tr>
            <td style="width: 60%"><a class="text-reset"
               href="board/requestBdCont?requestBdNum=123"> 제목 </a></td>
            <td style="width: 10%" class="text-center">아이디</td>
            <td style="width: 20%" class="text-center">날짜</td>
            <td style="width: 10%" class="text-center">조회수</td>
         </tr>
      </tbody>
      </table>
      <nav aria-label="Page navigation example">
         <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#"
               aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
            </a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#"
               aria-label="Next"> <span aria-hidden="true">&raquo;</span>
            </a></li>
         </ul>
      </nav>
	<table>
	<tr><td></td>
	<td><table>
	<form name=search method=post action="">	
	<!-- 검색어를 이용하여 글제목, 작성자, 글내용 중에 하나를 입력 받아 처리하기 위한 부분 -->
	<tr>
	<td>
	<select name="search">
	<option value="">글제목</option>
	<option value="">작성자</option>
	<option value="">글내용</option>
	</select>
	</td>
	<td><input type="text" size=20 name="key"></td>
	<td><a href="#"><img src="" border="0"></a></td>
	</tr>
	</form>
	</table>
	</td>
	<td><a href="#"><img src="" border="0"></a></td>
	</tr>
	</table>
	</div>
	<script type="text/javascript" src="/resource/js/bootstrap.js"></script>
</body>
</html>