<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/board/resources/jquery-1.11.0.min.js"></script>
<script>
	function boardupdate(){
		$.ajax({
			url: "./board_updateReg",
			type: "post",
			data: $("#board_updateReg").serialize(),
			datatype: "html",
			success: function(cnt){
				if(cnt==1){
					console.log('수정성공');
				} else {
					console.log('수정실패');
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
	<h2>board update</h2>
	<form action="#" method="post" id="board_updateReg" enctype="multipart/form-data">
	<input type="hidden" name="board_no" value="${board_detail.board_no}">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="${board_detail.title}" required></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="contents" required>${board_detail.contents}</textarea></td>
		</tr>
	</table>
	</form>
	<div><button onclick="boardupdate();">수정</button></div>
</body>
</html>