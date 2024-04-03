<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const a = () => {
	let win = open("down.jsp", "win", "width=400,height=400")
}

const b = (type) => {
	location.href = "${pageContext.request.contextPath }/dataroom/favo?num=${dr.num }&id=${sessionScope.loginId}&type=" + type;
}

</script>
</head>
<body>
<h3>상세 페이지</h3>
<div id="res" style="border:1px solid blue;display:none;position:absolute;top:100px;left:200px"></div>
<a href="${pageContext.request.contextPath }/dataroom/list">LIST</a><br/>
<form action="${pageContext.request.contextPath }/dataroom/detail" method="post" name="f">
<input type="hidden" name="dataroom" value="${dr.fname }">
<table border="1">
<tr>
<th>NUM</th><td><input type="text" name="num" value="${dr.num}" readonly></td>
</tr>
<tr>
<th>WRITER</th><td><input type="text" name="writer" value="${dr.writer }" readonly></td>
</tr>
<tr>
<th>WDATE</th><td><input type="text" name="wdate" value="${dr.wdate }" readonly></td>
</tr>
<tr>
<th>TITLE</th><td><input type="text" name="title" value="${dr.title }"></td>
</tr>
<tr>
<th>CONTENT</th><td><textarea name="content" rows="15" cols="22" readonly>${dr.content }</textarea></td>
</tr>
<tr>
<th>FILE</th><td>${dr.fname }&nbsp;<input type="button" value="다운로드" onclick="a()"></td>
</tr>
<tr>
<th>DOWNLOAD CNT</th><td>${dr.cnt }</td>
</tr>
<tr>
<th>FAVORITE CNT</th>
<td>${dr.fcnt }
<c:if test="${flag }"><input type="button" value="좋아요 취소" onclick="b(2)"></c:if>
<c:if test="${not flag }"><input type="button" value="좋아요" onclick="b(1)"></c:if>
</td>
</tr>
</table>
</form>
</body>
</html>