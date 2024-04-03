<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>이미지 게시판</h3>
<c:if test="${empty sessionScope.loginId }">
	<a href="${pageContext.request.contextPath }/mem/join">회원가입</a><br/>
	<a href="${pageContext.request.contextPath }/mem/login">로그인</a><br/>
</c:if>
<c:if test="${not empty sessionScope.loginId }">
	${sessionScope.loginId }님 로그인중 / 로그인 타입:${sessionScope.loginType }<br/>
	<a href="${pageContext.request.contextPath }/mem/myinfo">내정보확인</a><br/>
	<a href="${pageContext.request.contextPath }/mem/logout">로그아웃</a><br/>
	<a href="${pageContext.request.contextPath }/mem/out">탈퇴</a><br/>
	<a href="${pageContext.request.contextPath }/imgboard/list">이미지 글목록</a><br/>
</c:if>
</body>
</html>