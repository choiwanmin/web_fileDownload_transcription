<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>자료실</h3>
<a href="${pageContext.request.contextPath }/dataroom/add">자료 올리기</a><br/>
<table border="1">
<tr><th>num</th><th>title</th><th>writer</th></tr>
<c:forEach var="d" items="${list }">
<tr>
<td>${d.num }</td>
<td><a href="${pageContext.request.contextPath }/dataroom/detail?num=${d.num }&id=${sessionScope.loginId }">${d.title }</a></td>
<td>${d.writer }</td>
</tr>
</c:forEach>
</table>
</html>