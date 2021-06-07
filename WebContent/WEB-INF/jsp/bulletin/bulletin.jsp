<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bulletin.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>

<script>
	$(function() {
		CKEDITOR.replace('content', {
			filebrowserUploadUrl: '${pageContext.request.contextPath }/fileUpload',
			height: '600px',
			width: '800px'
		});
	});
</script>
</head>
<body>
<div align="center">
	<h3>게시글 내용보기</h3>
		<form id="frm" action="bulletinUpdate.do" method="POST">
-			<input type="hidden" name="id" value ="${bulletin.id}">
			<input type="hidden" name="num" value="${bulletin.id}">

		<table border='1'>
			<tr>
				<th>순번</th>
				<td>${bulletin.id}</td>
				<th>작성자</th>
				<td>${bulletin.writer}</td>
				<th>작성일자</th>
				<td>${bulletin.regDate}</td>
				<th>조회수</th>
				<td>${bulletin.hit}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="7">
					<c:if test="${id eq bulletin.writer}">
						<input type="text" id="ctitle" name="title" value="${bulletin.title }">
					</c:if>
					<c:if test="${id ne bulletin.writer}">
						${bulletin.title }
					</c:if>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="7">
					<c:if test="${id eq bulletin.writer}">
						<textarea id="content" name= "content"rows="6" cols="90">${bulletin.content }</textarea>
					</c:if>
					<c:if test="${id ne bulletin.writer}">
						${bulletin.content }
					</c:if>
				</td>
			</tr>
		</table>
			<input type="button" onclick="location.href='bulletinListPaging.do'" value="목록보기">
			<c:if test="${id eq bulletin.writer}">
				<button type="button" onclick="location.href='bulletinUpdate.do?id=${bulletin.id}'">삭제</button>
				<input type="submit" value="수정">
			</c:if>
	</form>
</div>
</body>
</html>