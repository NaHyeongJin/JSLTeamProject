<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>

</script>
<body>
<table class="table table-bordered">


	<div>
			  <div class="alert alert-light" role="alert">
  				<label for="exampleDropdownFormEmail2" style="font-size: 30px;"> Login </label>
			  </div>
			  
			  <div class="form-group" align="center">
			    <label for="exampleDropdownFormEmail2" > 아이디 </label>
			    <input type="email" name="" class="form-control" id="exampleDropdownFormEmail2" placeholder="ID" style="width: 30%;" >
			  </div>
			  
			  <div class="form-group" align="center">
			    <label for="exampleDropdownFormPassword2"> 비밀번호 </label>
			    <input type="password"  name="" class="form-control" id="exampleDropdownFormPassword2" placeholder="Password" style="width: 30%;" >
			  </div>

			<br>  
		    <div align="center">
		    <button type="button" class="btn btn-outline-success"> Login </button>
		    <a href="index.jsp"><button type="button" class="btn btn-outline-success"> Home </button></a>
			</div>
	</div>
	
	    <br><br>


</body>
<%@ include file="/include/footer.jsp" %> 	
</html>