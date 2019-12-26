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
		var del_chk = confirm('������ �����Ͻðڽ��ϱ�?');
		if(del_chk){
			$.ajax({
				url: "./board_del?board_no=${board_detail.board_no}",
				type: "post",
				dataType: "html",
				data: "${board_detail.board_no}",
				success: function(cnt) {
					if(cnt==1){
						console.log('��������');
					} else {
						console.log('��������');
					}
					location.href="./";
				},
				error: function(request,status,error) {
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					console.log('Controller���� ����');
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
			<button onclick="board_del(${board_detail.board_no})">�����ϱ�</button>
		</div>
		memo : ������ ���� ���������� ��������������, ���� �����ϰų� �����Ҷ� ����ó��
	</div>
</body>
</html>