<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>bulletinInsertForm.jsp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<style>
th {
	text-align: center;
}
</style>
<script>
	$(function() {
		CKEDITOR.replace('content', {
			filebrowserUploadUrl : '${pageContext.request.contextPath }/fileUpload', // 파일 업로드 서블렛
			height : '600px',
			width : '800px'
		});
	})

	function formCheck() {
		if (frm.title.value == "") {
			alert("제목을 입력하세요.");
			frm.title.focus();
			return false;
		}
		frm.submit();
	}
</script>
</head>

<body>
	<div align="center">
		<h3>게시글 작성</h3>
		<br>
		<form id="frm" action="bulletinInsert.do" method="post">
			<input type="hidden" name="id" value="${id }">
			<div style="width: 50%">
				<table class="table">
					<tr>
						<th>제목</th>
						<td colspan="5"><input type="text" id="title" name="title"
							size="70"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="5"><textarea id="content" name="content"
								rows="6" cols="120"></textarea></td>
					</tr>
				</table>
				<div>
					<button type="button" onclick="location.href='main.do'">홈으로</button>
					<button type="button" onclick="formCheck()">등록</button>
				</div>
			</div>
		</form>
	</div>

</body>

</html>