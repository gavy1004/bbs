<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1">
	<c:forEach items="${cartList }" var="vo">
		<tr>
			<th>${vo.itemCode }</th>
			<th>${vo.itemQty }</th>
			<th><img src="upload/${vo.itemImage }" width="200" height="100"></img></th>
			<th>${vo.itemQty }</th>
			<th>${vo.itemName }</th>
			<th>${vo.itemDesc }</th>
		</tr>
	</c:forEach>
</table>
