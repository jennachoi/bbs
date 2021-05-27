<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<div>
		<table border="1" width="80%" align="center">
			<tr>
				<th>상품정보</th>
				<th>수량</th>
				<th>금액</th>
				<th>총 금액</th>
			</tr>
			<c:forEach items="${cartList }" var="vo">
			<tr>
				<td>${vo.itemName }</td>
				<td>${vo.itemQty }</td>
				<td>${vo.price}</td>
				<td>금액</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>