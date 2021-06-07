<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- noticeForm.jsp -->
<!-- 제목 내용 제출 -> 호출 noticeInsert.do (컨트롤등록) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>

<script>
	$(function() {
		CKEDITOR.replace('content', {
			filebrowserUploadUrl: '${pageContext.request.contextPath }/fileUpload',
			height: '600px',
			width: '800px'
		});
	})
	
	function insertCheck() {
		if(frm.title.value == null) {
			alert("제목을 입력하세요");
			frm.title.focus();
			return false;
		}
 		if(frm.content.value == null) {
			alert("내용을 입력해 주세요");
			frm.content.focus();
			return false;
		}
		
		frm.submit();
	}
</script>
<body>
<div align="center">
	<h3>등록하기</h3>
	<form id="frm" action="noticeInsert.do" method="post">
		<div style="width:800px">
			<table class="table" border="1">
				<tr>
					<th>제목</th>
					<td colspan="5" width="200" ><input type="text" name ="title" id="title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="5"><textarea  rows="6" cols="90" name ="content" id="content"></textarea></td>
				</tr>
			</table> 
		</div>
			<div>
				<button type='button' onclick='insertCheck()'>등록</button>
				<button type='reset'>취소</button>
			</div>
	</form>
</div>
</body>