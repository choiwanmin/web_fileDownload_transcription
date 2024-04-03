<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글작성</h3>
<form action="${pageContext.request.contextPath }/dataroom/add" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>writer</th><td><input type="text" name="writer" value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>title</th><td><input type="text" name="title"></td></tr>
<tr><th>file</th><td><input type="file" name="fname"></td></tr>
<tr><th>content</th><td><input type="text" name="content"></td></tr>
</table>
<input type="submit" value="올리기">
</form>
</body>
</html>