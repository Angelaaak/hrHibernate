<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hr.overtime.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%!@SuppressWarnings("unchecked")%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>HR員工系統</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
.t1 {
	text-align: center;
}

.b1 {
	font-size: 12px;
}
</style>
</head>
<body>
	<div class="container t1">
		<h3>統計結果</h3>
		<table id="idtable" class="table table-bordered table-sm t1">
			<tr>

				<th>類型</th>
				<th>申請日</th>
				<th>員工編號</th>
				<th>姓名</th>
				<th>部門</th>
				<th>職稱</th>
				<th>加班類型</th>
				<th>加班日期</th>
				<th>開始時間</th>
				<th>結束時間</th>
				<th>加班時數</th>
				<th>加班事由</th>
				<th>審核結果</th>
				<th>行政簽核</th>
			</tr>

			<%
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			List<OverTimePending> overTimeList = (ArrayList<OverTimePending>) request.getAttribute("overTimeList");

			for (OverTimePending overTimePending : overTimeList) {
			%>

			<tr>
				<td><%=overTimePending.getType()%></td>
				<td><%=sdf.format(overTimePending.getDateOfApplication())%></td>
				<td><%=overTimePending.getEmpNo()%></td>
				<td><%=overTimePending.getEmpName()%></td>
				<td><%=overTimePending.getDepartment()%></td>
				<td><%=overTimePending.getPosition()%></td>
				<td><%=overTimePending.getOvertimeCategory()%></td>
				<td><%=sdf.format(overTimePending.getOverTimeDate())%></td>
				<td><%=overTimePending.getStartingTime()%></td>
				<td><%=overTimePending.getEndingTime()%></td>
				<td><%=overTimePending.getOverTimeHours()%></td>
				<td><%=overTimePending.getReason()%></td>
				<td><a href="#" class="btn btn-danger "><%=overTimePending.getResult()%></a></td>
				<td><a
					href="http://localhost:8080/HR/ManagerUpdateServletAction.do?ID=<%=overTimePending.getId()%>&type=passed"><button
							type="button" class="btn btn-primary btn-lg b1"onclick="return del();">Pass</button></a> <a
					href="http://localhost:8080/HR/ManagerUpdateServletAction.do?ID=<%=overTimePending.getId()%>&type=denied"><button
							type="button" class="btn btn-primary btn-lg b1"onclick="return del1();">Deny</button></a></td>
			</tr>

			<%
			}
			%>
		</table>
		<a href="http://localhost:8080/HR/frame/index.html"><button type="button" class="btn btn-primary">Return</button></a>
		<!-- <input class="btn btn-primary" type="button" value="add row" id="buttonAdd" > -->
	</div>
	<script>
		function del() {
			var msg = "審核確定通過嗎？\n\n請確認！";
			if (confirm(msg) == true) {
				return true;
			} else {
				return false;
			}
		}
		function del1() {
			var msg = "是否確定退件？\n\n請確認！";
			if (confirm(msg) == true) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</body>
</html>