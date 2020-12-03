<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ include file="/include/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>MAIN</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.js"></script>
<link rel="stylesheet" href="/resource/css/bootstrap.css">

<script>


	function inputCheckSpecial(){
		
  	var strobj = document.all.id; 
 	re = /[~!@\#$%^&*\()\-=+_']/gi;
  		if(re.test(strobj.value)){
   	   		alert("아이디에 특수문자는 입력하실수 없습니다.");
    		strobj.value=strobj.value.replace(re,"");
  }
}

</script>

<script>

	function send(){
		
		var string  = /admin/;
		if(frm.id.value==""){
			alert("회원아이디를 입력해주세요");
			frm.id.focus();
			return;

		}
		
		
		if(string.test(frm.id.value)){
			
			alert("admin 아이디는 관리자만 사용이 가능합니다.");
			frm.tel.focus();
			return;

		}
		

		if(frm.pw.value==""){

			alert("비밀번호를 입력해주세요");
			frm.pw.focus();
			return;

		}
		
		 if(frm.pw.value.length<8) {
		     alert("비밀번호는 8자 이상 입력해주세요.");
		     frm.pw.focus();
		     return;
		   }
		 
		 if(frm.name.value.length>10) {
		     alert("10자 이상의 이름은 입력이 불가능합니다.");
		     frm.pw.focus();
		     return;
		   }
		 

		if(frm.name.value==""){
			
			alert("이름을 입력해주세요");
			frm.name.focus();
			return;

		}

		if(frm.email.value==""){

			alert("이메일을 입력해주세요");
			frm.email.focus();
			return;

		}
		
		if(frm.email2.value==""){

			alert("이메일을 입력해주세요");
			frm.email2.focus();
			return;

		}
		
		if(frm.tel1.value==""){
			
			alert("연락처가 입력되지않았습니다");
			frm.tel1.focus();
			return;

		}
		
		if(frm.tel1.value.length>3){
			
			alert("연락처의 첫자리는 3자리 이하만 가능합니다.");
			frm.tel1.focus();
			return;

		}
		
		if(frm.tel2.value==""){
			
			alert("연락처가 입력되지않았습니다");
			frm.tel2.focus();
			return;

		}
		
		if(frm.tel2.value.length>4){
			
			alert("연락처의 중간자리는 4자리 이하만 가능합니다.");
			frm.tel2.focus();
			return;

		}
		
		if(frm.tel3.value==""){
			
			alert("연락처가 입력되지않았습니다");
			frm.tel3.focus();
			return;
		
		}
		
		if(frm.tel3.value.length>4){
			
			alert("연락처의 마지막자리는 4자리 이하만 가능합니다.");
			frm.tel3.focus();
			return;

		}
		
		frm.submit();
		
	}
	
	</script>
</head>
<body>

<form name="frm" method="post" action="/sign_up">

  <div class="form-group">
    <label for="inputAddress2">ID</label>
    <input type="text" class="form-control" onkeyup="inputCheckSpecial()" name="id" placeholder="특수문자를 입력할 수 없습니다.">
  </div>
  
  <div class="form-group">
    <label for="inputAddress2">Password</label>
    <input type="password" class="form-control" name="pw" placeholder="비밀번호는 8자리 이상 입력해주세요.">
  </div>
  
  <div class="form-group">
    <label for="inputAddress2">Name</label>
    <input type="text" class="form-control" name="name">
  </div>
  
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="text" class="form-control" name="email">
    </div>
    
    <div class="form-group col-md-6">
      <label for="inputPassword4">Email domain</label>
      <div class="input-group flex-nowrap">
     	 <div class="input-group-prepend">
     		 <span class="input-group-text" id="addon-wrapping">@</span>
     	 </div>
      <input type="text" class="form-control" name="email2" aria-label="Username" aria-describedby="addon-wrapping">
      </div>
    </div>
  
   <div class="form-group col-md-4">
      <label for="inputZip">Tel_First</label>
      <input type="number" class="form-control" name="tel1">
    </div>
  
  <div class="form-group col-md-4">
      <label for="inputZip">Tel_Middle</label>
      <input type="number" class="form-control" name="tel2">
    </div>
  
  <div class="form-group col-md-4">
      <label for="inputZip">Tel_Last</label>
      <input type="number" class="form-control" name="tel3">
    </div>
    </div>
  
  
  <br>
  
  <center> <button type="button"  class="btn btn-primary" onClick="send()">Sign up</button> 
  		   <button type="reset"  class="btn btn-primary">Delete</button> </center>
  
</form>

</body>
<%@ include file="/include/footer.jsp" %> 	
</html>