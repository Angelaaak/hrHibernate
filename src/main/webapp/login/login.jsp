<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>log_in</title>
<link rel="icon" href="favicon.png" />
<style>
* {
	margin: 0px;
	padding: 0px;
}

.underlayer {
	width: 100vw;
	height: 100vh;
	background-color: #dddfe8;
	padding-top: 200px;
}

.content {
	width: 500px;
	height: fit-content;
	text-align: center;
	font-family: Microsoft JhengHei;
	font-weight: bold;
	color: #252525;
	/*border: 3px solid black;    /*參考線*/
	margin: auto;
	padding: 20px;
}

.logo {
	padding: 10px;
}

#cmpyname {
	font-size: 28px;
	text-decoration: underline;
}

input {
	height: 25px;
	width:	205px;
	border: 0;
	border-radius: 5px;
	margin: 5px;
	box-shadow: 3px 3px 10px silver;
}

#btnlogin {
	width: 40px;
	height: 25px;
	background-color: #7973AE;
	color: #F9f9f9;
	font-family: Microsoft JhengHei;
	margin: 10px;
	box-shadow: 0px 0px;
}

.ps {
	font-size: 12px;
}
</style>

</head>
<body>
	<div class="underlayer">
		<div class="content">
			<div class="logo">
				<img id="logo" src="logo_hr.png" alt="logo" width="135"><br />
				<span id="cmpyname">HR有限公司&nbsp&nbsp人力資源管理系統</span>
			</div>
			<div class="input">
				<form action="../LoginServlet" method="POST">
					<!--待修改-->
					<input type="text" id="account" name="account" placeholder="&nbsp帳號" required autocomplete="off"><br />
					<input type="password" id="pwd" name="pwd" placeholder="&nbsp密碼" required autocomplete="off"><br />
					<input type="submit" id="btnlogin" name="btnlogin" value="登&nbsp入"><br />
					<span class="ps">[如遇登入問題，請與系統管理員連絡]</span>
				</form>
			</div>

		</div>

	</div>
</body>
</html>