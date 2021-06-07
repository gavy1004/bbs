<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeList.jsp</title>
<script>
	function formSubmit(id) {
		frm.id.value = id;
		frm.submit();
	}
	
	function $(".color").on {
		mouseover : function() {
			$(this).css({
				'background-color' : 'aqua'
			});
		},
		mouseout : function() {
			$(this).css({
				'background-color' : ''
			});
	}
	
</script>
</head>
<body>
	<h3>공지사항리스트</h3>
	<form id ='frm' action="notice.do" method="post">
		<input type='hidden' id='id' name='id'>
	</form>
	<div align="center">
		<div style="width:90%">
			<table class="table" border="1">
				<tr class="color">
					<th>순번</th>
					<th>제목</th>
					<th>작성일자</th>
					<th>조회수</th>
				</tr> 	<!-- 해당되는 걸렉션 items 한건한건 담아올떄 var -->
				<c:forEach	items="${noticeList }" var="vo">
					<tr class="color" onclick="formSubmit(${vo.id})">
						<td width="100">${vo.id }</td>
						<td width="200">${vo.title }</td>
						<td width="150">${vo.regDate }</td>
						<td width="100">${vo.hit }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<button type="button" onclick="location.href='main.do'">홈</button>
			<c:if test="${id eq 'admin' }">
			<button type="button" onclick="location.href='noticeForm.do'">등록</button>
			</c:if>
		</div>
	</div>
</body>
</html>