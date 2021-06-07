<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
attribute값을 읽어오겠다 
request.setAttribute("member",???);
session.setAttribute("member",???);
contextPath.setAttribute("member",???);
 -->
<c:if test="${empty id }">
<h1>Welcome to Home Guest</h1>
</c:if>
<c:if test="${not empty id }">
<h1>Welcome to Home ${member.name }</h1>
</c:if>



