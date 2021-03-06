<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a class="navbar-brand" href="main.do">Home</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">

			<li class="nav-item"><a class="nav-link" href="noticeListPaging.do">공지사항</a>
			</li>

			<li class="nav-item"><a class="nav-link" href="bulletinListPaging.do">자유게시판</a></li>

			<li class="nav-item"><a class="nav-link" href="#">소개하는 글</a></li>

			<c:if test="${not empty id }">
				<li class="nav-item"><a class="nav-link"
					href="memberLoginOut.do">로그아웃</a></li>
			</c:if>

			<c:if test="${empty id }">
				<li class="nav-item"><a class="nav-link"
					href="memberLoginForm.do">로그인</a></li>
				<li class="nav-item"><a class="nav-link"
					href="memberJoinForm.do">회원가입</a></li>
			</c:if>
			<c:if test="${empty id }">
				<li class="nav-item"><a class="nav-link">👤 Guest</a></li>
			</c:if>
			<c:if test="${id == 'admin'}">
				<li class="nav-item"><a class="nav-link">👩‍🔧 Admin</a></li>
			</c:if>
			<c:if test="${not empty id && id != 'admin'}">
				<li class="nav-item"><a class="nav-link">🙍 ${id }</a></li>
			</c:if>
		</ul>
	</div>
</nav>