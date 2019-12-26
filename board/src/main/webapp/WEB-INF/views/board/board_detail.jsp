<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
			
		</div>
	</div>
</body>
</html>