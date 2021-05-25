<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
th {
	text-align: center;
}
</style>
<script>
	function noticeUpdate(){
		let id = document.getElementById("cid").innerHTML;
		let title = document.getElementById("ctitle").value;
		let content = document.getElementById("ccontent").value;
		
		frm.id.value = id;
		frm.title.value = title;
		frm.content.value = content;
		frm.submit();
	}
	function noticeDelete(){
		let id = document.getElementById("cid").innerHTML;
		frmd.id.value = id;
		frmd.submit();
	}
</script>
<div align="center">
	<h3>공지사항 내용보기</h3>
	<br>
	<form id="frm" action="noticeUpdate.do" method="post">
		<input type="hidden" name="id">
		<input type="hidden" name="title">
		<input type="hidden" name="content">
	</form>
		<form id="frmd" action="noticeDelete.do" method="post">
		<input type="hidden" name="id">
	</form>
	<div style="width: 50%">
		<table class="table">
			<tr>
				<th width="100">순번</th>
				<td id="cid">${notice.id }</td>
				<th>작성일자</th>
				<td>${notice.regDate }</td>
				<th>조회수</th>
				<td>${notice.hit +1}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="5">
				<input type="text" id="ctitle" value="${notice.title }" size="70">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="5"><textarea id="ccontent" rows="6" cols="120">${notice.content }</textarea></td>
			</tr>
		</table>
		<br>
		<div>
			<button type="button" onclick="location.href='noticeListPaging.do'">목록보기</button>
			<button type="button" onclick="location.href='main.do'">홈으로</button>
			<c:if test="${id eq 'admin' }">
				<button type="button" onclick="noticeUpdate()">수정</button>
				<button type="button" onclick="noticeDelete()">삭제</button>
			</c:if>
		</div>
	</div>
</div>
