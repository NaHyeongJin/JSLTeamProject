<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>

<body class="pt-5">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="index">Method Shopping Page</a>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
						href="index">홈 <span class="sr-only">(current)</span>
					</a></li>

					<!-- 관리자 로그인  -->
					<c:if test="${Grade == 'A'}">
						<li class="nav-item"><a class="nav-link"
							href="LogoutServlet.do"> 로그아웃</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/join/register.jsp">내정보가기</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/join/register.jsp">회원목록리스트</a></li>
					</c:if>
					<!-- 회원 로그인  -->
					<c:if test="${Grade == 'B'}">
						<li class="nav-item"><a class="nav-link"
							href="LogoutServlet.do">로그아웃</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/join/register.jsp">내정보가기</a></li>
					</c:if>
					<!-- 비회원 로그인 -->
					<c:if test="${empty loginedMemberId}">
						<li class="nav-item"><a class="nav-link" href="login.do">로그인</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/join/register.jsp">회원가입</a></li>
					</c:if>

				</ul>
			</div>
		</div>
	</nav>
	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<div class="col-lg-3">

				<h3 class="my-4 text-center">Category</h3>
				<div class="list-group mb-4">
					<a class="list-group-item list-group-item-info text-center font-weight-bold" href="index">자유게시판</a>
					<a href="qna_board?page=1"
						class="list-group-item list-group-item-action text-center font-weight-bold">질문과 답변</a>
					<a href="index"
						class="list-group-item list-group-item-action text-center font-weight-bold">자료실(다운로드)</a>
					<a href="index"
						class="list-group-item list-group-item-action text-center font-weight-bold">쇼핑몰</a>
					<a href="index"
						class="list-group-item list-group-item-action text-center font-weight-bold">공지사항</a>
				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9 my-4 mb-4">