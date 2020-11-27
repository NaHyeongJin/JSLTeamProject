<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{margin:0; padding:0;}
	ul,li{list-style:none;}
	.logo{color:#fff; text-align:center; background-color:#0040FF;
			padding:16px 0;}
	.navi{padding:12px 0; overflow:hidden; background-color:#BCA9F5;}
	.navi ul,li{float:left; padding:0 20px; text-align:center;}
	.content{background-color:#E6E6E6; padding:16px; height:400px;}
	.title{text-align:center; padding:22px;}
	.footer{padding:16px 0; text-align:center; background-color:#0040FF;}
	.content table{width:700px; margin:0 auto;}
	.content table th, td{border:1px solid #bbb;}
	.content table .btn_group{text-align:center;}
	.a table th, th{;}
</style>
</head>
<body>
	<div class="header">
		<header>
			<h1 class="logo">(과정평가형 정보처리산업기사)학생관리 프로그램 ver1.0 </h1>
			<nav>
				<ul class="navi">
					<li><a href="">로그인</a></li>
					<li><a href="">회원가입</a></li>
					<li><a href="">공지사항</a></li>
					<li><a href="">자유게시판</a></li>
					<li><a href="">질문과답변</a></li>
					<li><a href="">자료실(파일업로드)</a></li>
					<li><a href="">쇼핑몰</a></li>
					<li><a href="index.jsp">홈으로</a></li>
				</ul>
			</nav>
		</header>
	</div>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">자료실(파일 업로드)</h2>
					<table border="0" cellspacing="1" width="100%" align="center">
      <tr>
        <td colspan="7" align="center" valign="center" height="20">
        <font size="4" face="돋움" color="blue">
        <b>참 좋은 자료들</b></font></td></tr>
      <tr>
        <td colspan="7" align="right" valign="middle" height="20">
		  <font size="2" face="고딕">전체 : <b>총 개시물 갯수</b>건 </font>
		</td>
	  </tr>
	  <tr bgcolor="e3e9ff">
        <td width="7%" align="center" height="20"><font face="돋움" size="2">번호</font></td>
        <td width="32%" align="center" height="20"><font face="돋움" size="2">제목</font></td>
        <td width="35%" align="center" height="20"><font face="돋움" size="2">파일이름 및 크기</font></td>
        <td width="10%" align="center" height="20"><font face="돋움" size="2">올린이</font></td>
        <td width="11%" align="center" height="20"><font face="돋움" size="2">날짜</font></td>
        <td width="5%" align="center" height="20"><font face="돋움" size="2">조회</font></td></tr>
      <tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
        <td align="center" height="25">
        <font face="돋움" size="2" color="#000000">게시물번호 들어가는곳</font></td>
				<td align="left" height="20">&nbsp;<font face="돋움" size="2">제목들어가는곳</font></td>
        <td align="center" height="20"><font face="돋움" size="2">파일이름들어가는곳</td>
				<td align="left" height="20"><font face="돋움" size="2">이름들어가는곳</font></td>
				<td align="left" height="20"><font face="돋움" size="2">등록일자들어가는곳</font></td>
				<td align="center" height="20"><font face="돋움" size="2">조회수들어가는곳</font></td> 	      
			</tr>
	   <tr>
         <td colspan="5" align="center">
         <font face="돋움" size="2" color="#000000">페이지 버튼 들어가는곳</td>
		</tr>
   <tr>
      <td colspan="7" align="right">
				<a href=""><button>글쓰기</button></a>
      &nbsp;
	  </td>
   </tr>
	<form name="pds" method="post" action="pds_list">
     <table border="0" cellspacing="0" width="100%">
      <tr>
      <td><center>
      <font color="#004080" size="4" face="Courier New"><strong>Search&nbsp;</strong></font>
        <select name="search" size="1" style="font-family: 돋움체">
		   <option value="subject">글제목</option>
		   <option value="name">작성자</option>
		   <option value="contents">글내용</option>
		</select>
		&nbsp;&nbsp;<input type="text" name="key" size="20" value="">
		&nbsp;&nbsp;<input type="button" align="middle" onClick="send()" value="검색">
	   </td>
	   </tr>
    </table>
	</form>
   </table>
				
			</div>
		</section>
	</div>
	<div class="footer">
		<footer>
			<p>HRDKOREQ Copyright@2016 All right reserve.
			Human Resources Development Service of Korea</p>
		</footer>
	</div>
</body>
</html>