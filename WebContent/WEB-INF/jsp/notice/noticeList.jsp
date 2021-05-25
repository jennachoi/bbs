<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeList.jsp</title>
<style>
th {
	background-color: lightgray;
}
</style>
<script>
	function formSubmit(id) {
		frm.id.value = id;
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
	<h3>공지사항 리스트</h3><br>
	<form id="frm" action="notice.do" method="post">
		<input type="hidden" id="id" name="id">
	</form>
		<div style="width: 80%">
			<table class="table">
				<tr>
					<th width="100">순번</th>
					<th width="200">제목</th>
					<th width="150">작성일자</th>
					<th width="100">조회수</th>
				</tr>
				<c:forEach items="${noticeList }" var="vo">
					<tr onclick="formSubmit(${vo.id })">
						<td>${vo.id }</td>
						<td>${vo.title }</td>
						<td>${vo.regDate }</td>
						<td>${vo.hit }</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<div>
				<button type="button" onclick="location.href='main.do'">홈으로</button>
				<c:if test="${id eq 'admin' }">
					<button type="button" onclick="location.href='noticeInsertForm.do'">등록</button>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>