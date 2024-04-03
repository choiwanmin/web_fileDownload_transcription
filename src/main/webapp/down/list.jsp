<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>자료실</h3>
<ul>
<c:forEach var="f" items="${files }">
<li>
	<a href="${pageContext.request.contextPath }/down/down?fname=${f }">${f }</a>
</li>
</c:forEach>
</ul>
</body>
</html>