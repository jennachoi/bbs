<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty id }">
	<h1> 👤 Guest님 환영합니다! </h1>
</c:if>

<c:if test="${id == 'admin'}">
	<h1> 👩‍🔧 관리자님 환영합니다! </h1>
</c:if>

<c:if test="${not empty id && id != 'admin'}">
	<h1> 🙍 ${vo.name }님 환영합니다! </h1>
</c:if>