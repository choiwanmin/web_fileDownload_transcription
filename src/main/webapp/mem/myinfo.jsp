<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = () => {
	let val = '판매자';
	if('${m.type}' == '1') {
		val = '구매자';
	}
	document.getElementById('type').innerHTML = val;
}
</script>
</head>
<body>
<h3>내 정보 확인</h3>
<form action="${pageContext.request.contextPath }/mem/myinfo" method="post">
<table border="1">
<tr><th>ID</th><td><input type="text" name="id" value="${m.id }" readonly></td></tr>
<tr><th>PWD</th><td><input type="text" name="pwd" value="${m.pwd }" ></td></tr>
<tr><th>NAME</th><td><input type="text" value="${m.name }" readonly></td></tr>
<tr><th>EMAIL</th><td><input type="text" value="${m.email }" readonly></td></tr>
<tr><th>TYPE</th><td id="type"></td></tr>
<tr><th>EDIT</th><td><input type="submit" value="edit"></td></tr>
</table>
</form>
</body>
</html>