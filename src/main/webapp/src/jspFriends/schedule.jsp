<%--
  Created by IntelliJ IDEA.
  User: gimsangsu
  Date: 2022/06/10
  Time: 5:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WTF</title>
    <link rel="stylesheet" href="../style/todaylist.css">
    <link rel="stylesheet" href="../style/common.css">
    <link rel="stylesheet" href="../style/homebutton.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hahmlet&family=Kdam+Thmor+Pro&display=swap" rel="stylesheet">

</head>
<body>
<div id="box" class="box">
    <div class="homebutton">
        <a href="main.jsp">HOME</a>
    </div>
    <div id="twoTableContainer">
        <div id="weeklyTable">
            <div class="Wtitle">
                <div>Weekly</div>
                <div>2022.06</div>
            </div>
            <div class="WBody">
                <div class="fuck"></div>
                <div class="Sunday"onmousedown="mouseDown(this.id)" onmouseup="mouseUp(this.id)" onclick="showSchedule();">Sun</div>
                <div class="Monday" onmouseout="Monday_onmouseout();" onmouseover="Monday_onmouseover();" onmousedown="mouseDown()" onmouseup="mouseUp()" >Mon</div>
                <div class="Tuesday"onmouseout="Tuesday_onmouseout();" onmouseover="Tuesday_onmouseover();">Tue</div>
                <div class="Wednesday"onmouseout="Wednesday_onmouseout();" onmouseover="Wednesday_onmouseover();">Wed</div>
                <div class="Thursday"onmouseout="Thursday_onmouseout();" onmouseover="Thursday_onmouseover();">Thur</div>
                <div class="Friday"onmouseout="Friday_onmouseout();" onmouseover="Friday_onmouseover();">Fri</div>
                <div class="Saturday"onmouseout="Saturday_onmouseout();" onmouseover="Saturday_onmouseover();">Sat</div>
            </div>
        </div>
        <div id="dailyTable">
            <div class="Dtitle">
                <div>daily</div>
                <div class="today">2022.06.09</div>
            </div>
            <div class="DBody">
                <div class="am">am</div>
                <div class="blank"></div>
                <div class="pm">pm</div>
                <div class="leftBox">
                    <div id="amBox"></div>
                </div>
                <div class="timeTable">12<br><br>1<br><br>2<br><br>3<br><br>4<br><br>5<br><br>6<br><br>7<br><br>8<br><br>9<br><br>10<br><br>11</div>
                <div class="rightBox">
                    <div id="pmBox"></div>
                </div>
                <div class="lastblank"></div>
                <div class="lastline"></div>
            </div>
        </div>
    </div>
</div>
<script src="../js/todaylist.js"></script>
<script src="../js/main.js"></script>
</body>
</html>