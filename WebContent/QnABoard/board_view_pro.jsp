<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
if(${bool}) {
	location.href="qna_view?idx=${idx}&isAnswer=${isAnswer}&passCheck=false&page=${page}";
}
else {
	window.history.back();
}
</script>