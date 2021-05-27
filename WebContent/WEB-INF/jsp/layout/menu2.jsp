<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
a {
	text-decoration: none;
}

a:hover {
	text-decoration: none;
}

a:visited {
	color: black;
}
</style>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="index.do"><img
			src="upload/abclogo.png"></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link"
					href="noticeListPaging.do">Notice</a></li>
				<li class="nav-item"><a class="nav-link"
					href="bulletinListPaging.do">Board</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="productList.do">전체상품</a></li>
						<li><hr class="dropdown-divider" /></li>
						<li><a class="dropdown-item" href="#!">Popular Items</a></li>
						<li><a class="dropdown-item" href="#!">New Arrivals</a></li>
					</ul></li>
			</ul>
			<c:choose>
				<c:when test="${empty id }">
					<form class="d-flex">
						<button class="btn btn-outline-dark" type="button"><a href="memberLoginForm.do">Login</a></button>&nbsp;
						<button class="btn btn-outline-dark" type="submit"><a href="memberJoinForm.do">Join</a></button>&nbsp;
						<button class="btn btn-outline-dark" type="submit">👤 Guest</button>
					</form>
				</c:when>
				<c:otherwise>
					<form class="d-flex">
						<button class="btn btn-outline-dark" type="button"><a href="memberLoginOut.do">Logout</a></button>&nbsp;
					</form>
					<form class="d-flex" action="cartList.do">
						<input type="hidden" name="uid" value="${id }">
						<button class="btn btn-outline-dark" type="submit">🙍 ${id } 
						<i class="bi-cart-fill me-1"></i> Cart <span class="badge bg-dark text-white ms-1 rounded-pill">${cartCnt }</span>
						</button>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>
<!-- Bootstrap core JS-->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>