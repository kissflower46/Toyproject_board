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
	function board_del(board_no) {
		var del_chk = confirm('정말로 삭제하시겠습니까?');
		if(del_chk){
			$.ajax({
				url: "./board_del?board_no=${board_detail.board_no}",
				type: "post",
				dataType: "html",
				data: "${board_detail.board_no}",
				success: function(cnt) {
					if(cnt==1){
						console.log('삭제성공');
					} else {
						console.log('삭제실패');
					}
					location.href="./";
				},
				error: function(request,status,error) {
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					console.log('Controller접속 실패');
					console.log(request);
					console.log(status);
					console.log(error);
				}
			});
		}
	}
</script>
</head>
<body>
	<div>
		<table border="1" cellpadding="3" cellspacing="0">
			<tr>
				<td>제목</td><td>${board_detail.title}</td>
			</tr>
			<tr>
				<td>내용</td><td>${board_detail.contents}</td>
			</tr>
			<tr>
				<td>작성일</td><td>${board_detail.board_date}</td>
			</tr>
		</table>
		<div>
			<button onclick="location.href='./board_update?board_no=${board_detail.board_no}'">수정하기</button>
			<button onclick="board_del(${board_detail.board_no})">삭제하기</button>
		</div>
		memo : 누군가 여기 들어오기전에 글을삭제했을때, 글을 수정하거나 삭제할때 예외처리
	</div>
</body>
</html>