<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.hr.bulletin.model.Bulletin,com.hr.bulletin.action.DemoQueryOne"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改貼文</title>
 <style>
        body {
            font-family: Microsoft JhengHei;
        }

        input {
            padding: 4px;
            font-size: 16px;
        }

        .i2 {
            border: 1px solid rgb(53, 52, 52);
        }

        .t1 {
            width: 100px;
            float: left;
            text-align: right;
        }

        .t2 {
            float: right;
            text-align: right;
        }
        .input1{
            background-color:#7973AE ;
            color: white;
            border:0;
            padding: 4px;
            font-size:16px;
            border-radius: 3px;
            position:relative;
			left: 60px;
			margin:10px;
        }
        
        .td2{
        width: 180px;

        }
        
        .i3 {
            color: white;
           	background-color: white;
           	border: 0px solid white;
        }
        
    </style>
</head>
<body>
 <script src="../res/jquery-3.6.0.min.js"></script>
  <jsp:useBean id="post" scope="request" class="com.hr.bulletin.model.Bulletin"/>
    <%
    Bulletin rb = (Bulletin)request.getAttribute("resultBeanQ");
    String type =rb.getType(); 
	String typeValue = "";
	if (type.equals("公告")) {
		typeValue="<input type='radio' name='posttype' value='公告' checked><label for=''>公告</label><input type='radio' name='posttype' value='活動'>活動";
	}
	else{
		typeValue="<input type='radio' name='posttype' value='公告' ><label for=''>公告</label><input type='radio' name='posttype' value='活動' checked>活動";
	} 
     %>
    <h2>修改貼文</h2>
    <form method="get" action="DemoUpdate.do">

        <table>
            <tr>
                <td><label for="" class="t1">類型 :</label>
                <td>
				<%=typeValue %> 

            <tr>
                <td><label for="" class="t1">主旨 :</label>
                <td>
                    <input type="text" class="i2" name="title" size="30" maxlength="30" required value="<%= rb.getTitle() %>"/>
				<td>
                    <input type="text" class="i3" name="postno" size="30" maxlength="30" required value="<%= rb.getPostno() %>"/>
            <tr>
                <td><label for="" class="t1">說明 :</label>
                <td>
                    <textarea name="explanation" class="i2" id="explanation" cols="50" rows="15" required style="font-size: 16px;"><%= rb.getExplanation() %></textarea>
            <tr>
                <td><label for="" class="t1">有效日期 :</label>
                <td>
                    <input type="date" class="i2" name="exp" required value="<%=rb.getExp() %>">
               </table>
            <input type="submit" value="確認修改" class="input1"/>
    </form>
</body>
</html>