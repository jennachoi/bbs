<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty member }">
	<h1> 🏳️‍🌈[Guest]님 환영합니다✨</h1>
</c:if>
<c:if test="${not empty member }">
	<h1> 🏳️‍🌈${member.name }님 환영합니다✨</h1>
</c:if>