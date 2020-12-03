<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>${vo.r_subject }</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
<link rel="stylesheet" href="resource/css/bootstrap.css">
<script>
function room_del(){
	window.open("roomdelete?r_idx=${vo.r_idx}", "", "width=400, height=300");
	

}  
</script>
</head>
<body>

	<div class="container my-1">
		<div class="row">
			<table class="table">
				<thead>
					<tr class="table-active">
						<th scope="col" style="width: 60%">${vo.r_subject }<br>
						${(fn:contains(vo.r_id, 'admin')) ? '관리자' : vo.id }</th>
						
						<th scope="col" style="width: 40%" class="text-right">조회수 :
							${(fn:contains(vo.r_id, 'admin')) ? vo.r_cnt : vo.r_cnt}<br> ${vo.r_regdate.substring(0,10) }
						</th>
				</tr>
			</thead>
			
				
					
				<tbody>
					<tr>
						<td><pre>${(fn:contains(vo.r_id, 'admin')) ? vo.r_contents : vo.r_contents}</pre></td>
					</tr>
			</tbody>
		</table>
	</div>
</div>
<nav class="navbar navbar-expand-lg">
		<button class="btn btn-secondary mr-sm-2"
		onClick="location.href='roommodify?r_idx=${vo.r_idx }'">수정하기</button>
		<button type="submit" class="btn btn-secondary mr-sm-2"
		onClick="location.href='javascript:room_del()'">삭제하기</button>
		<button class="btn btn-secondary mr-sm-2" onClick="location.href='room'">돌아가기</button>
		
</nav>
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
</body>
<%@ include file="/include/footer.jsp"%> 	
</html>