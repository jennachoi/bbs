<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
th {
	text-align: center;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.16.1/full/ckeditor.js"></script>
<script>
	$(function() {
		CKEDITOR.replace('content', {
			filebrowserUploadUrl : '${pageContext.request.contextPath }/fileUpload', // 파일 업로드 서블렛
			height : '600px',
			width : '100%'
		});
	})

	$('#btnUpdate').click(function() {
		e.preventDefalut();
		console.log(CKEDITOR.instances.content.getData());
		
		let id = $('#id').val
		let title = $('#title').val;
		let content = CKEDITOR.instances.content.getData();

		$.ajax({
			url:'ajaxBulletinUpdate',
			data: {
				id: id,
				title: title,
				content: content
			},
			type:'post',
			success: function(){},
			error: function(){}
		})
			
		frm.id.value = id;
		frm.title.value = title;
		frm.content.value = content;
		
		console.log(id);
		console.log(title);
		console.log(content);
		//frm.submit();
	});
	
	function deleteBulletin() {
		frmd.submit();
	}
	
</script>
<div align="center">
	<h3>게시글 내용보기</h3>
	<br>
	<form id="frmd" action="bulletinDelete.do" method="post">
		<input type="hidden" name="id" id="id" value="${bulletin.id }">
	</form>
	<form id="frm" action="bulletinUpdate.do" method="post">
		<input type="hidden" name="writer" id="writer" value="${id }">
		<input type="hidden" name="id" id="id" value="${bulletin.id }">
		<div style="width: 60%">
			<table class="table">
				<tr>
					<th width="100">순번</th>
					<td>${bulletin.id }</td>
					<th width="100">작성자</th>
					<td>${bulletin.writer }</td>
					<th width="100">작성일자</th>
					<td>${bulletin.regDate }</td>
					<th width="100">조회수</th>
					<td>${bulletin.hit +1}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="7"><c:if test="${id eq bulletin.writer }">
							<input type="text" id="title" name="title" value="${bulletin.title }" size="70">
						</c:if> <c:if test="${id ne bulletin.writer }">
						${bulletin.title }
					</c:if></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="7">
						<c:if test="${id eq bulletin.writer }">
							<textarea id="content" name="content" rows="6" cols="120">${bulletin.content }</textarea>
						</c:if> 
						<c:if test="${id ne bulletin.writer }">
							${bulletin.content }
						</c:if>
					</td>					
				</tr>
			</table>
		</div>
		<div>
			<button type="button" onclick="location.href='bulletinListPaging.do'">목록보기</button>
			<button type="button" onclick="location.href='main.do'">홈으로</button>
			<c:if test="${id eq bulletin.writer }">
				<button type="submit" id="btnUpdate">수정</button>
				<button type="button" onclick="deleteBulletin()">삭제</button>
			</c:if>
		</div>
	</form>
</div>
