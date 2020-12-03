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
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
<link rel="stylesheet" href="resource/css/bootstrap.css">
<script>
	function room_del(){
		window.open("roomdelete?idx=${vo.r_idx}", "", "width=400, height=300");
	}  
</script>
</head>
<body>
	<table border="0" width="90%" align="center" cellspacing="0" style="border-width:1px;border-color:#0066cc;border-style:outset;">
       <tr bgcolor="e3e9ff">
         <td class="title">
           <font size="2" face="돋움">${vo.r_subject }
           </font></td></tr>
  <tr>  
    <td class="content">
    <p align="right"><font size="2" face="돋움">${vo.r_id } / ${vo.r_regdate.substring(0,10) } / ${vo.r_cnt }
    		<p>${vo.r_contents }</p>
    <c:if test="${!empty vo.r_filename }">
    <a href="Room/upload/${vo.r_filename }">&nbsp;${vo.r_filename }</a>
	</c:if>
	</font></td></tr>
  </table>
  <table>
  <tr align="center">
  <button onClick="location.href='roommodify?r_idx=${vo.r_idx }'">수정하기</button>
  <button onClick="location.href='javascript:room_del()'">삭제하기</button>
  <button onClick="location.href='room'">돌아가기</button>
  </tr>
  </table>
	<script type="text/javascript" src="resource/js/bootstrap.js"></script>
</body>
<%@ include file="/include/footer.jsp"%>
</html>