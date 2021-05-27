<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div
			class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<!-- 첫번째 데이터 -->
			<div class="col mb-5">
				<div class="card h-100">
					<!-- Product image-->
					<img class="card-img-top"
						src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
					<!-- Product details-->
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">Fancy Product</h5>
							<!-- Product price-->
							$40.00 - $80.00
						</div>
					</div>
					<!-- Product actions-->
					<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
						<div class="text-center">
							<a class="btn btn-outline-dark mt-auto" href="#">View options</a>
						</div>
					</div>
				</div>
			</div>

			<c:forEach items="${ProductList }" var="vo">
				<!-- 두번째 데이터 -->
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<c:if test="${vo.sale eq 'Y' }">
						<div class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						</c:if>
						<!-- Product image-->
						<img class="card-img-top"
							src="upload/${vo.itemImage }" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">${vo.itemName }</h5>
								<!-- Product reviews-->
								<div class="d-flex justify-content-center small text-warning mb-2">
									<c:forEach begin="1" end="${vo.likeIt }">
										<div class="bi-star-fill"></div>
									</c:forEach>
									(${vo.likeIt })
								</div>
								<!-- Product price-->
								<c:if test="${vo.sale eq 'Y' }">
									<span class="text-muted text-decoration-line-through">
									<fmt:formatNumber type="currency" value="${vo.price }"></fmt:formatNumber></span>
									<fmt:formatNumber type="currency" value="${vo.salePrice }"></fmt:formatNumber>
								</c:if>
								<c:if test="${vo.sale eq 'N' }">
									<fmt:formatNumber type="currency" value="${vo.price }"></fmt:formatNumber>
								</c:if>								
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" onclick="addCart('${vo.itemCode }')">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>
<script>
	function addCart(itemCode){
		$.ajax({
			url: '${pageContext.request.contextPath }/addCart.do',
			data: {
				id: '${id }', 
				itemCode: itemCode
			},
			success: function (result){
				console.log(result);
				location.href= 'productList.do';
			},
			error: function (err){
				console.log(err);
			}
		});
	};
</script>