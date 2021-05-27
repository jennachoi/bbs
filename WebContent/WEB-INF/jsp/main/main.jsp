<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
Date nowTime = new Date();
SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
%>
<style>
.nav {
	display: inline-block;
	border-radius: 15em;
	margin: 3px;
	padding: 15px;
	font-weight: 900;
	background-color: lightgray;
}

.nav1 {
	display: inline;
	border: 0px 1px 0px 0px solid;
	border-color: black;
	box-shadow: 0px 5px 0px black;
	margin: 10px;
	padding: 5px;
	font-weight: 900;
	font-size: 18px;
}

.d1 {
	width: 80%;
	align: center;
}

th {
	text-align: center;
	font-size: 16px;
}

.t1 {
	width: 80%;
	align: center;
	text-align: center;
	margin: 10px;
	align: center;
}

.t1 * {
	border-bottom: 1px solid #ddd;
}

.t1 tr:hover {
	background-color: #f5f5f5;
}

</style>
<script>
	function formSubmit(id) {
		frm.id.value = id;
		frm.submit();
	}
	function formnSubmit(id) {
		frmn.id.value = id;
		frmn.submit();
	}
</script>
<div align="center">
<div class="d1">
	<c:if test="${empty id }">
		<h3 class="nav">👤 Guest님 환영합니다!</h3>
	</c:if>

	<c:if test="${id == 'admin'}">
		<h3 class="nav">👩‍🔧 관리자님 환영합니다!</h3>
	</c:if>

	<c:if test="${not empty id && id != 'admin'}">
		<h3 class="nav">🙍 ${vo.name }님 환영합니다!</h3>
	</c:if>
	<br>
	<p>
		현재 시간 :
		<%=sf.format(nowTime)%></p>
	<div align="center">
		<br>
		<table width="80%">
			<tr>
				<td colspan="2"><H3>
						<b>📰 최근 게시물 </b>
					</H3></td>
			</tr>
			<tr>
				<td><a href="noticeListPaging.do" class="nav1">📣 공지사항</a></td>
				<td><a href="bulletinListPaging.do" class="nav1">📋 자유게시판</a></td>
			</tr>
			<tr>
				<td>
					<form id="frmn" action="notice.do" method="post">
						<input type="hidden" id="id" name="id">
					</form>
					<table class="t1">
						<tr>
							<th>순번</th>
							<th>제목</th>
							<th>작성일자</th>
						</tr>
						<c:forEach items="${NoticeNewList }" var="vo">
							<tr onclick="formnSubmit(${vo.id })">
								<td>${vo.id }</td>
								<td>${vo.title }</td>
								<td>${vo.regDate }</td>
							</tr>
						</c:forEach>
					</table>
				</td>
				<td>
					<form id="frm" action="bulletinSelect.do" method="post">
						<input type="hidden" id="id" name="id">
					</form>
					<table class="t1">
						<tr>
							<th>순번</th>
							<th>제목</th>
							<th>작성일자</th>
						</tr>
						<c:forEach items="${BulletinNewList }" var="vo">
							<tr onclick="formSubmit(${vo.id })">
								<td>${vo.id }</td>
								<td>${vo.title }</td>
								<td>${vo.regDate }</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</div>
</div>
</div>


