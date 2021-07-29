<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index_test</title>
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
	width: 1000px;
	height: fit-content;
	text-align: center;
	font-family: Microsoft JhengHei;
	font-weight: bold;
	color: #252525;
	/* border: 3px solid black; */
	margin: auto;
	padding: 20px;
}

.header {
	font-size: 20px;
	margin-bottom: 20px;
}

input {
	height: 30px;
	width: 205px;
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

fieldset {
	height: 450px;
	border-radius: 10px;
	padding: 10px;
	border: 0px;
}

.task {
	border-radius: 20px;
	background: #f9f9f9;
	color: #252525;
	height: 375px;
	width: 230px;
	display: inline-block;
	margin: 0px 5px;
}
</style>
</head>
<body>
	<div class="underlayer">
		<div class="content">
			<div class="header">			
				<span>${empid}</span> <span>，您好</span>
			</div>
			<div class="input">
				<form action="../LogoutServlet" method="POST">
					<!--待修改-->
					<fieldset>
						<div class="task">
							<span>待辦項目</span>
						</div>
						<div class="task">
							<span>會議</span>
						</div>
						<div class="task">
							<span>待繳項目</span>
						</div>
						<div class="task">
							<span>其他</span>
						</div>
						<br /> <input type="submit" id="btnlogin" name="btnlogin" value="登&nbsp出"><br />
						<!--待：click判斷登入情況-->
						<span class="ps">[如遇問題，請與系統管理員連絡]</span>
					</fieldset>
				</form>
			</div>

		</div>

	</div>
</body>
</html>