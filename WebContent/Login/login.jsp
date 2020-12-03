<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script>
function ok(){
	if(login.id.value==""){
		alert("아이디를 입력해주세요");
		login.id.focus();
		return false;
	}
	if(login.pw.value==""){
		alert("비밀번호를 입력해주세요");
		login.pw.focus();
		return false;
	}
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<div>
	<form action="/login.do" method="post" name = login>
			  <div class="alert alert-light" role="alert">
  				<label for="exampleDropdownFormEmail2" style="font-size: 30px;"> Login </label>
			  </div>
			  
			  
			  <div class="form-group" align="center">
			    <label for="exampleDropdownFormEmail2" > 아이디 </label>
			    <input type="text" name="id" class="form-control" id="exampleDropdownFormEmail2" placeholder="ID" style="width: 30%;" >
			  </div>
 
			  <div class="form-group" align="center">
			    <label for="exampleDropdownFormPassword2"> 비밀번호 </label>
			    <input type="password"  name="pw" class="form-control" id="exampleDropdownFormPassword2" placeholder="Password" style="width: 30%;">
			  </div>
			
			<br>  
		    <div align="center">
		    
		    <button type="submit" class="btn btn-outline-success" onclick="return ok()"> Login </button> 
		    <a href="index.jsp"><button type="button" class="btn btn-outline-success"> Home </button></a>
			</div>
	</form>		
	</div>
	


</body>
<%@ include file="/include/footer.jsp" %> 	
</html>