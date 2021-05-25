<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberLoginForm.jsp</title>
<style>
th {
	width: 150px;
	background-color: lightgray;
	padding: 5px;
}

td {
	width: 300px;
	padding: 5px;
}
</style>
<script>
	function formCheck() {
		if(frm.memberId.value == "") {
			alert("ID를 입력하세요.")
			frm.memberId.focus();
			return false;
		}
		if(frm.memberPwd.value == "") {
			alert("비밀번호를 입력하세요.")
			frm.memberPwd.focus();
			return false;
		}
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
			<h1>로그인</h1>
		<div>
			<form id="frm" action="memberLogin.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th>아이디</th>
							<td><input type="text" id="memberId" name="memberId"></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" id="memberPwd" name="memberPwd"></td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<button type="button" onclick="formCheck()">로그인</button>
					<button type="reset">취소</button>
					<button type="button" onclick="location.href='main.do'">홈</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>