<%--
  Created by IntelliJ IDEA.
  User: gimsangsu
  Date: 2022/06/10
  Time: 6:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="../style/common.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kdam+Thmor+Pro&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kdam+Thmor+Pro&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../style/timetableproto.css">
    <link rel="stylesheet" href="../style/homebutton.css">
    <title>재민이가 만드는 일정 페이지입니다</title>
</head>
<body>
<div id="box" class="box">
    <div class="homebutton">
        <a href="main.jsp">HOME</a>
    </div>
    <div id="contain">
        <div class="title">
            <div>MON</div>
            <div>THU</div>
            <div>WED</div>
            <div>THU</div>
            <div>FRI</div>
        </div>
        <div class="container">
            <div class="time">
                <div>1교시<br>09:00 ~ 10:00</div>
                <div>2교시<br>10:00 ~ 11:00</div>
                <div>3교시<br>11:00 ~ 12:00</div>
                <div>4교시<br>12:00 ~ 13:00</div>
                <div>5교시<br>13:00 ~ 14:00</div>
                <div>6교시<br>14:00 ~ 15:00</div>
                <div>7교시<br>15:00 ~ 16:00</div>
                <div>8교시<br>16:00 ~ 17:00</div>
                <div>9교시<br>17:00 ~ 18:00</div>
            </div>
            <div class="schedule">
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
            </div>
            <div class="schedule">
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
            </div>
            <div class="schedule">
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true">-</div>
            </div>
            <div class="schedule">
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
            </div>
            <div class="schedule">
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
                <div class="hour" draggable="true"></div>
            </div>
        </div>
    </div>
</div>
<dialog id="favDialog">
    <form id="context" method="dialog">
        <label><div>어느 요일이냐?</div>
            <select id="weekDay">
                <option value="mon">월요일</option>
                <option value="tue">화요일</option>
                <option value="wed">수요일</option>
                <option value="thu">목요일</option>
                <option value="fri">금요일</option>
            </select>
        </label>
        <label><div>몇시 시작이냐?</div>
            <select id="classStartTime">
                <option value="class1">1교시(09:00~10:00)</option>
                <option value="class2">2교시(10:00~11:00)</option>
                <option value="class3">3교시(11:00~12:00)</option>
                <option value="class4">4교시(12:00~13:00)</option>
                <option value="class5">5교시(13:00~14:00)</option>
                <option value="class6">6교시(14:00~15:00)</option>
                <option value="class7">7교시(15:00~16:00)</option>
                <option value="class8">8교시(16:00~17:00)</option>
                <option value="class9">9교시(17:00~18:00)</option>
            </select>
        </label>
        <label><div>몇시 끝나냐?</div>
            <select id="classEndTime">
                <option value="class1">1교시(09:00~10:00)</option>
                <option value="class2">2교시(10:00~11:00)</option>
                <option value="class3">3교시(11:00~12:00)</option>
                <option value="class4">4교시(12:00~13:00)</option>
                <option value="class5">5교시(13:00~14:00)</option>
                <option value="class6">6교시(14:00~15:00)</option>
                <option value="class7">7교시(15:00~16:00)</option>
                <option value="class8">8교시(16:00~17:00)</option>
                <option value="class9">9교시(17:00~18:00)</option>
            </select>
        </label>
        <label><div>어느 교수님이냐?</div>
            <input type="text" id="professor">
        </label>
        <label><div>건물은?</div>
            <input type="text" id="building">
        </label>
        <label><div>강의실은?</div>
            <input type="text" id="classRoom">
        </label>
        <div id="box_button">
            <button value="cancel">Cancel</button>
            <button id="confirmBtn" value="default" onclick="confirm();">Confirm</button>
        </div>
    </form>
</dialog>
<script src="../js/timetable.js"></script>
</body>
</html>
