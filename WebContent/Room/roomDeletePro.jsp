<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${row==1}">
		<script>
			window.opener.location.replace("room");
			self.close();
		</script>
	</c:when>
		<c:otherwise>
		<script>
			alert("비밀번호가 맞지않습니다.\n\n글 작성시의 비밀번호를 입력해 주세요.");
			history.back();
		</script>
		</c:otherwise>
</c:choose>