<%--
  Created by IntelliJ IDEA.
  User: gimsangsu
  Date: 2022/06/09
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../style/common.css">
    <link rel="stylesheet" href="../style/main.css">
    <link rel="stylesheet" href="../style/calendar.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="../style/login.css">
    <title>정현이가 만드는 메인페이지</title>
</head>
<body>
<div id="box" class="box">
    <div class="first-innerbox" style="width: 26%;">
        <div class="innerbox">
            <div id="loginbutton" class="loginbutton_default" onmousedown="mouseDown(this.id)" onmouseup="mouseUp(this.id)" >로그인</div>
        </div>
        <div class="innerbox" style="height: 90%;">
            <div id="button1" class="button_default" onmousedown="mouseDown(this.id)" onmouseup="mouseUp(this.id)" onClick="location.href='timetableproto.html'">시간표</div>
            <div id="button2" class="button_default" onmousedown="mouseDown(this.id)" onmouseup="mouseUp(this.id)" onClick="location.href='homeworklist.html'">과제 목록</div>
            <div id="button3" class="button_default" onmousedown="mouseDown(this.id)" onmouseup="mouseUp(this.id)" onClick="location.href='todaylist.html'">오늘 할 일</div>
        </div>
    </div>
    <div class="innerbox" style="width : 36%; flex-shrink: 0;">
        <canvas id="clock"></canvas>
        <div id="calendar" class="calendar">
            <div class="container-calendar">
                <h3 id="monthAndYear"></h3>
                <div class="button-container-calendar">
                    <button id="previous" onclick="previous()">&#8249;</button>
                    <button id="next" onclick="next()">&#8250;</button>
                </div>
                <table class="table-calendar" id="calendar" data-lang="en">
                    <thead id="thead-month"></thead>
                    <tbody id="calendar-body"></tbody>
                </table>
                <div class="footer-container-calendar" style="display:none">
                    <select id="month" onchange="jump()">
                        <option value=0>Jan</option>
                        <option value=1>Feb</option>
                        <option value=2>Mar</option>
                        <option value=3>Apr</option>
                        <option value=4>May</option>
                        <option value=5>Jun</option>
                        <option value=6>Jul</option>
                        <option value=7>Aug</option>
                        <option value=8>Sep</option>
                        <option value=9>Oct</option>
                        <option value=10>Nov</option>
                        <option value=11>Dec</option>
                    </select>
                    <select id="year" onchange="jump()"></select>
                </div>
            </div>
        </div>
    </div>

    <div class="innerbox" style="width : 26%;">
        <div id="alert_box" class="alert_box">
            <p>dd</p>
            <p>dddd</p>
            <p>dd</p>
            <p>dddd</p>
            <p>dd</p>
            <p>ddddd</p>
            <p>dd</p>
            <p>dddd</p>
            <p>dd</p>
            <p>dddd</p>
            <p>dd</p>
        </div>
        <div id="alert_box" class="alert_box" style="display: flex; text-align: center; justify-content: center;">
            <span style="font-size:25px; padding-top:4px; padding-right: 5vh;">다크모드</span>
            <input type="checkbox" id="switch3" onclick="darkMode()">
            <label for="switch3" class="round"></label>
        </div>
        <div id="lb-audio">
            <audio controls>
                <source src="../music/기억을 걷는 시간.mp3" type="audio/mpeg">
            </audio>
        </div>
    </div>
    <dialog id="favDialog">
        <!-- <form id="context" method="dialog"> -->
        <div class="login-box">
            <h2>Login</h2>
            <form method="dialog">
                <div class="user-box">
                    <input type="text" name="name" required="">
                    <label>Username</label>
                </div>
                <div class="user-box">
                    <input type="password" name="password" required="">
                    <label>Password</label>
                </div>
                <div class="btnList">
                    <button href="#">Submit</button>
                    <button class="closeModal">Cancel</button>
                    <button class="registerModal">register</button>
                </div>
            </form>
        </div>
        <!-- </form> -->
    </dialog>
</div>
<script src="../js/login.js"></script>
<script src="../js/main.js"></script>
<script src="../js/calendar.js"></script>
</body>
</html>