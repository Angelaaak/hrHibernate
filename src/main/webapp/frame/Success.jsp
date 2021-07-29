<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Successful page</title>
<style>
div{   
  	height: 300px;
  	line-height: 100px; 
}
h1 {
  font-size: 2.2rem;
  color: #444;
  margin-bottom: 10px;
  font-Family: Arial;
}
button {
	padding: 4px;
	font-size: 16px;
	background-color: #7973AE;
	color: white;
	border: 0;
	border-radius: 3px;
}
 .btn{
  width: 150px;
  background-color: #5995fd;
  border: none;
  outline: none;
  height: 49px;
  border-radius: 49px;
  color: #fff;
  text-transform: uppercase;
  font-weight: 600;
  margin: 10px 0;
  cursor: pointer;
  transition: 0.5s;
}
</style>
</head>
<body>
	
<div align="center">
	<h1>登入成功</h1>
	<br>
	<a href="http://localhost:8080/hr/bulletin/DemoQuery.do"><button type="button" class="btn">公佈欄管理</button></a>
</div>
	
</body>
</html>