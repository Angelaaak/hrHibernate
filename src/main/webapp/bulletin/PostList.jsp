<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.hr.bulletin.model.Bulletin,com.hr.bulletin.action.DemoInsert"%>
	<%!@SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>貼文管理</title>

<style>
.pltb {
	border: 2px solid gray;
	border-collapse: collapse;
	text-align: center;
}

td, th {
	border: 1px solid gray;
}

.tdno {
	width: 50px;
}

.tdtype {
	width: 50px;
}

.tdtitle {
	width: 300px;
}

.tdpd {
	width: 100px;
}

.tdexp {
	width: 100px;
}

.tdedit {
	width: 100px;
}

button {
	padding: 4px;
	font-size: 16px;
	background-color: #7973AE;
	color: white;
	border: 0;
	border-radius: 3px;
}

.insert {
	margin: 0 0 10px 0;
}
</style>
</head>
<body>
	<script src="../res/jquery-3.6.0.min.js"></script>
	<h2>公佈欄貼文列表</h2>
	<a href="http://localhost:8080/hr/bulletin/Insert.jsp"><button
			class="insert">新增貼文</button></a>
	<a href="http://localhost:8080/hr/LogoutServlet"><button
			class="insert">登出</button></a>
	<table class="pltb">
		<tr>
			<td class="tdno">編號</td>
			<td class="tdtype">類型</td>
			<td class="tdtitle">主旨</td>
			<td class="tdpd">張貼日期</td>
			<td class="tdexp">有效日期</td>
			<td class="tdedit">編輯</td>
		</tr>
		<%
		List<Bulletin> resultBean2 = (ArrayList<Bulletin>) request.getAttribute("resultBean2");
		for(Bulletin rb : resultBean2){
		%>
		<tr>
			<td><%=rb.getPostno()%></td>
			<td><%=rb.getType()%></td>
			<td><%=rb.getTitle()%></td>
			<td><%=rb.getPostDate()%></td>
			<td><%=rb.getExp()%></td>
			<td>
				<a href="http://localhost:8080/hr/DemoQueryOne.do?postno=<%=rb.getPostno()%>"><button class="updatep">修改</button></a>
				<a href="http://localhost:8080/hr/DemoDelete.do?postno=<%=rb.getPostno()%>"><button class="deletep">刪除</button></a>
			</td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>
