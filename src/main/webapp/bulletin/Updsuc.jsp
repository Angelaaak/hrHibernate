<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改成功</title>
<style>

</style>
</head>
<body>
<%
	boolean result = (boolean) request.getAttribute("bresult");
	String dr = "";
	if (result == true)
		dr = "修改成功";
	else
		dr = "修改失敗";
	%>
	<h4><%=dr %></h4>
		<form method="get" action="DemoQuery.do">
		<input type="submit" value="回公佈欄管理" class="input1" />
	</form>
</body>
</html>