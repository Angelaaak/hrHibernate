<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="res/favicon.png" />
<link rel="stylesheet" href="css/index_frame.css">
<link rel="stylesheet" href="css/index_links.css">
<title>index</title>
<style>
.links:hover {background-color: black;}
</style>
</head>

<body>
	<div class="underlayer">
		<div class="leftside">
			<div class="logo">
				<img src="res/logo_frame.png">
				<!--用有框的-->
			</div>
			<div class="pglinks">
				<ul>
					<li id="index"><a href="${pageContext.request.contextPath}/frame/index.jsp">首頁</a></li>

					<li id="pg2"><a href="">出勤管理</a>
						<ul class="linkslist">
							<li class="links"><a href="${pageContext.request.contextPath}/checksystem/TopicClock-In.jsp"
								target="iframeMain">Check In/Check Out</a></li>
							<li class="links"><a href="${pageContext.request.contextPath}/OverTime/OverTime.html"
								target="iframeMain">Overtime Application</a></li>
							<li class="links"><a href="${pageContext.request.contextPath}/EmployeeInquiries"
								target="iframeMain">Overtime Query</a></li>
							<li class="links"><a href="${pageContext.request.contextPath}/ManagerInterface"
								target="iframeMain">Overtime Manager</a></li>
							<li class="links"><a
								href="${pageContext.request.contextPath}/complementsign/ComplementSignForm.html"
								target="iframeMain">Complement Sign Application</a></li>
							<li class="links"><a href="${pageContext.request.contextPath}/PendingApproval.html"
								target="iframeMain">PendingApproval</a></li>
							<li class="links"><a href="${pageContext.request.contextPath}/GetList" target="iframeMain">Leave
									Application</a></li>
							<li class="links"><a href="###" target="iframeMain">排班</a></li>
						</ul></li>
					<li id="pg3"><a href="">基本資料</a>
						<ul class="linkslist">
							<li class="links"><a href="###">未定義</a></li>
							<li class="links"><a href="###">未定義</a></li>
							<li class="links"><a href="${pageContext.request.contextPath}/DemoQuery.do"
							target="iframeMain">Bulletin Management"</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="rightside">
			<div class="head">
				<div class="cmpyname">
					<fieldset class="cmpytext">
						<div class="cmpytext01">
							<h2>&nbsp&nbspHR人力有限公司&nbsp&nbsp人力資源管理系統</h2>
						</div>
						<div class="cmpytext02">
							<span>特休剩餘時數：54小時</span> <span>加班補修剩餘時數：5小時</span><br /> <span
								style="font-size: 75%;">[到期日：2021/12/31]</span>
						</div>
					</fieldset>

				</div>
				<div class="userlog">
					<div id="user">
						使用者${EmpNo}<input type="submit" id="btnlogout" name="btnlogout"
							value="登&nbsp出">
					</div>
				</div>
			</div>
			<!--以上共版內容-->
			<div class="content">
				<iframe src="" name="iframeMain" style="border: none" width="100%"
					height="100%">
					<p style="width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.2);">各頁內容放這裡</p>
				</iframe>
			</div>
		</div>

	</div>
</body>

</html>