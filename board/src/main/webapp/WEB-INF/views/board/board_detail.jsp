<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table border="1" cellpadding="3" cellspacing="0">
			<tr>
				<td>����</td><td>${board_detail.title}</td>
			</tr>
			<tr>
				<td>����</td><td>${board_detail.contents}</td>
			</tr>
			<tr>
				<td>�ۼ���</td><td>${board_detail.board_date}</td>
			</tr>
		</table>
		<div>
			<button onclick="location.href='./board_update?board_no=${board_detail.board_no}'">�����ϱ�</button>
			<button onclick="javascript:alert('���� �̱���')">�����ϱ�</button>
		</div>
		memo : ������ ���� ���������� ��������������, ���� �����ϰų� �����Ҷ� ����ó��
	</div>
</body>
</html>