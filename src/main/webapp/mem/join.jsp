<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript">
const check = () => {
	if(f.id.value.length <= 0) {
		alert("id는 필수 입력 사항");
		f.id.focus();
		return;
	}
	if(f.pwd.value.length <= 0) {
		alert("pwd는 필수 입력 사항");
		f.pwd.focus();
		return;
	}
	f.submit();
}
</script>
</head>
<body>
<h3>회원가입</h3>
<form action="${pageContext.request.contextPath }/mem/join" method="post" name="f">
<table border="1">
	<tr>
		<th>ID</th><td><input type="text" name="id"></td>
	</tr>
	<tr>
		<th>PWD</th><td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<th>NAME</th><td><input type="text" name="name"></td>
	</tr>
	<tr>
		<th>EMAIL</th><td><input type="text" name="email"></td>
	</tr>
	<tr>
		<th>TYPE</th>
		<td>
			<input type="radio" name="type" value="1" checked>구매자 
			<input type="radio" name="type" value="2">판매자 
		</td>
	</tr>
	<tr>
		<th>JOIN</th><td><input type="button" value="join" onclick="check()"></td>
	</tr>
</table>
</form>
</body>
</html>