<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
th {
	text-align: center;
}
</style>
<script>
	function noticeInsert(){
		let title = document.getElementById("title").value;
		let content = document.getElementById("content").value;
		
		frm.title.value = title;
		frm.content.value = content;
		frm.submit();
	}
</script>
<div align="center">
	<h3>공지사항 작성</h3>
	<br>
	<form id="frm" action="noticeInsert.do" method="post">
		<input type="hidden" name="title">
		<input type="hidden" name="content">
	</form>
	<div style="width: 50%">
		<table class="table">
			<tr>
				<th>제목</th>
				<td colspan="5">
				<input type="text" id="title" size="70">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="5"><textarea id="content" rows="6" cols="120"></textarea></td>
			</tr>
		</table>
		<br>
		<div>
			<button type="button" onclick="location.href='main.do'">홈으로</button>
			<button type="button" onclick="noticeInsert()">등록</button>
		</div>
	</div>
</div>
