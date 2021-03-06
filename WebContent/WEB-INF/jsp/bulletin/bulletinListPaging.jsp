<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bulletinListPaging.jsp</title>
<style>
th {
	background-color: lightgray;
}
.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}

tr:hover td{background-color: #ddd;}

</style>
<script>
	//게시글 Id로 조회
	function formSubmit(bulletinId) {
		frm.id.value = bulletinId;
		frm.submit();
	}
	function goPage(page) {
		location.href = "bulletinListPaging.do?page=" + page;
	}
</script>
</head>
<body>
	<div align="center">
	<h3>자유게시판 (Paging)</h3><br>
	<form id="frm" action="bulletinSelect.do" method="post">
		<input type="hidden" id="id" name="id">
	</form>
		<div style="width: 80%">
			<table class="table">
				<tr>
					<th width="100">순번</th>
					<th width="200">제목</th>
					<th width="100">작성자</th>
					<th width="150">작성일자</th>
					<th width="100">조회수</th>
				</tr>
				<c:forEach items="${BulletinList }" var="vo">
					<tr onclick="formSubmit(${vo.id })">
						<td>${vo.id }</td>
						<td>${vo.title }</td>
						<td>${vo.writer }</td>
						<td>${vo.regDate }</td>
						<td>${vo.hit }</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<button type="button" onclick="location.href='main.do'">홈으로</button>
				<c:if test="${id eq 'admin' }">
					<button type="button" onclick="location.href='bulletinInsertForm.do'">새 게시물 등록</button>
				</c:if>
			</div>
			<br>
			<br>
			<jsp:include page="../common/paging.jsp" flush="true">
			    <jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
			    <jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
			    <jsp:param name="startPageNo" value="${paging.startPageNo}" />
			    <jsp:param name="pageNo" value="${paging.pageNo}" />
			    <jsp:param name="endPageNo" value="${paging.endPageNo}" />
			    <jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
			    <jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
			</jsp:include>
		</div>
	</div>
</body>
</html>