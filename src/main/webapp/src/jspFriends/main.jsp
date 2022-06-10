<%@ page import="com.proto.controller.registServlet" %><%--
  Created by IntelliJ IDEA.
  User: gimsangsu
  Date: 2022/06/09
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
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
    <title>정현이가 만드는 페이지</title>
</head>
<body>
<div id="box" class="box">
    <div class="first-innerbox" style="width: 26%;">
        <div class="innerbox">
                <%
                    session = request.getSession();
                    if(session.getAttribute("userName") != null) {
                        System.out.println("why succuess");
                %>
                    <div id="loginbutton" class="loginbutton_default" onmousedown="mouseDown(this.id)" onmouseup="mouseUp(this.id)" onclick="location='logoutProc.jsp'">
                <%= session.getAttribute("userName")%>
                <%
                    } else {
                        System.out.println("why fail!");
                %>
                    <div id="loginbutton" class="loginbutton_default" onmousedown="mouseDown(this.id)" onclick="login()" onmouseup="mouseUp(this.id)" >
                로그인
                <%
                    }
                %>
            </div>
        </div>
        <div class="innerbox" style="height: 90%;">
            <div id="button1" class="button_default" onmousedown="mouseDown(this.id)" onmouseup="mouseUp(this.id)" method="post" onclick="location.href='<%= request.getContextPath() %>/showTable'">시간표</div>

            <div id="button2" class="button_default" onmousedown="mouseDown(this.id)" onmouseup="mouseUp(this.id)" onClick="location.href='homeworklist.html'">과제 목록</div>
            <div id="button3" class="button_default" onmousedown="mouseDown(this.id)" onmouseup="mouseUp(this.id)" onClick="location.href='schedule.jsp'">오늘 할 일</div>

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
            <p>Algorithm</p>
            <p>Math </p>
            <p>TOEIC R.C</p>
            <p>Computer System</p>
         
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
            <form method="post" action="<%= request.getContextPath() %>/login">
                <div class="user-box">
                    <input type="text" name="login_name">
                    <label>Username</label>
                </div>
                <div class="user-box">
                    <input type="password" name="login_password">
                    <label>Password</label>
                </div>
                <div class="btnList">
                    <button href="#">Submit</button>
                    <button class="closeModal">Cancel</button>
                    <button class="registerModal" id="registerbutton">register</button>
                </div>
            </form>
        </div>
        <!-- </form> -->
    </dialog>
    <dialog id="favDialog_register">
        <!-- <form id="context" method="dialog"> -->
        <div class="register-box">
            <h2>Register</h2>
            <form method="post" action="<%= request.getContextPath() %>/registUser">
                <div class="user-registerbox">
                    <input type="text" name="regist_name">
                    <label>ID</label>
                </div>
                <div class="user-registerbox">
                    <input type="password" name="regist_password">
                    <label>Password</label>
                </div>
                <div class="btnList">
                    <button href="#">Submit</button>
                    <button class="closeModal">Cancel</button>
                </div>
            </form>
        </div>
        <!-- </form> -->
    </dialog>
</div>
<script src="../js/login.js?v=<%=System.currentTimeMillis() %>"></script>
<script src="../js/main.js?v=<%=System.currentTimeMillis() %>"></script>
<script src="../js/calendar.js?v=<%=System.currentTimeMillis() %>"></script>
</body>
</html>