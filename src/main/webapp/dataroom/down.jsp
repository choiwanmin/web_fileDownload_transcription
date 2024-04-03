<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = () => {
	let fname = opener.document.f.dataroom.value;
	let atag = document.getElementById('atag');
	atag.innerHTML = fname;
	let num = opener.document.f.num.value
	atag.href = href="${pageContext.request.contextPath }/dataroom/down?fname=" + fname+"&num="+num;
}

const a = () => {
	opener.location.reload();
	close();
}
</script>
</head>
<body>
<h4>자료 다운로드</h4>
<a id="atag"></a><br/>
<br/>
<input type="button" value="닫기" onclick="a()">
</body>
</html>