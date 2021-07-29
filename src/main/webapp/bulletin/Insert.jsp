<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        
    </style>
</head>
<body>

    <h2>新增公佈欄貼文</h2>
    <form method="get" action="../DemoInsert.do">

        <table>
            <tr>
                <td><label for="" class="t1">類型 :</label>
                <td>
                    <input type="radio" name="posttype" value="公告" checked><label for="">公告</label>
                    <input type="radio" name="posttype" value="活動">活動

                <td class="td2">
            <tr>
                <td><label for="" class="t1">主旨 :</label>
                <td>
                    <input type="text" class="i2" name="title" size="30" maxlength="30" required />

            <tr>
                <td><label for="" class="t1">說明 :</label>
                <td>
                    <textarea name="explanation" class="i2" id="explanation" cols="50" rows="15" required style="font-size: 16px;"></textarea>
            <tr>
                <td><label for="" class="t1">有效日期 :</label>
                <td>
                    <input type="date" class="i2" name="exp" required >
               </table>
            <input type="submit" value="確認新增" class="input1"/>
            
    </form>

</body>
</html>