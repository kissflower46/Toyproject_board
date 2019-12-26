<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<script>
</script>

</head>
<body>

<div>
	<h2 style="align:center">Board list</h2>
	<table border="1" cellpadding="3" cellspacing="0">
		<tr>
			<td>No</td>
			<td>title</td>
			<td>date</td>
		</tr>
		<c:forEach items="${boardList}" var="board">
			<tr style="cursor:pointer" onclick="location.href='./boardDetail?board_no=${board.board_no}'">
				<td>${board.board_no}</td>
				<td>${board.title}</td>
				<td>${board.board_date}</td>
			</tr>
		</c:forEach>
	</table>
	<div style="margin-top:10px;">
		<button onclick="location.href='./board_insert'">[글쓰기]</button>
	</div>
</div>

</body>
</html>