<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>刪除結果</title>
<style>
</style>
</head>
<body>
	<%
	boolean result = (boolean) request.getAttribute("resultBeanDel");
	String dr = "";
	if (result == true)
		dr = "刪除成功";
	else
		dr = "刪除失敗";
	%>
	<h4><%=dr%></h4>
	<form method="get" action="DemoQuery.do">
		<input type="submit" value="回公佈欄管理" class="input1" />
	</form>
</body>
</html>