<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/board/resources/jquery-1.11.0.min.js"></script>
<script type="text/javascript">

	function boardinsert(){
		$.ajax({
			url: "./board_insertReg",
			type: "post",
			data: $("#board_insert").serialize(),
			datatype: "html",
			success: function(cnt){
				if(cnt==1){
					console.log('등록성공');
				} else {
					console.log('등록실패');
				}
			},
			error: function(request,status,error) {
				console.log('Controller접속 실패');
				console.log(request);
				console.log(status);
				console.log(error);
			}
		});
	}
</script>
</head>
<body>
<div>
	<h2>board insert</h2>
	<form action="#" method="post" id="board_insert" enctype="multipart/form-data">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" required></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="contents" required></textarea></td>
		</tr>
	</table>
	</form>
	<div><button onclick="boardinsert();">저장</button></div>
</div>
</body>
</html>