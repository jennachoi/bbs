<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
th {
	width: 150px;
	background-color: lightgray;
}

td {
	width: 300px;
}

span {
	font-weight: bold;
	color: red;
}
</style>
<script>
	//ID 중복체크
	$(function() {
		$('#idCheck').click(function() {
			if ($('#memberId').val() == "") {
				alert('ID를 입력하세요.');
				$('#memberId').focus();
				return;
			}
			$.ajax({
				url : 'ajaxMemberIdCheck',
				data : {
					id : $('#memberId').val()
				},
				type : 'post',
				success : function(data) {
					console.log(data);
					if (data > 0) {
						alert('존재하는 ID입니다. 다른 ID를 입력하세요.');
						$('#memberId').val(""); // id박스에 넣었던 값을 지움
						$('#memberId').focus();
					} else {
						alert('사용 가능한 ID입니다.');
						$('#idCheck').val('checked');
						$('#memberPwd').focus();
					}
				},
				error : function(err) {
					console.log(err);
				}
			}); // end of ajax
		}); // end of click function	
	});

	//공란체크
	function formCheck() {
		if (frm.memberId.value == "") {
			alert("ID를 입력하세요.");
			frm.memberId.focus(); // 커서 포커스가 가도록
			return false; // false가 나오면 처리가 멈춤
		}
		if (frm.idCheck.value == 'unChecked') {
			alert("ID 중복체크가 되지 않았습니다.");
			frm.idCheck.focus();
			return false;
		}
		if (frm.memberPwd.value == "") {
			alert("비밀번호를 입력하세요.");
			frm.memberPwd.focus();
			return false;
		}
		frm.submit(); // ID와 PWD를 다 넣으면 진행이 되도록
	}
</script>

<div align="center">
	<div>
		<h1>회원가입</h1>
	</div>
	<div>
		<form id="frm" action="memberJoin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th>아이디<span>*</span></th>
						<td><input type="text" id="memberId" name="memberId">
							<button type="button" id="idCheck" value="unChecked">중복체크</button></td>
					</tr>
					<tr>
						<th>비밀번호<span>*</span></th>
						<td><input type="password" id="memberPwd" name="memberPwd"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" id="memberName" name="memberName"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" id="memberAddr" name="memberAddr"
							size="35"></td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<button type="button" onclick="formCheck()">회원가입</button>
				<button type="reset">취소</button>
				<button type="button" onclick="location.href='main.do'">홈</button>
			</div>
		</form>
	</div>

</div>