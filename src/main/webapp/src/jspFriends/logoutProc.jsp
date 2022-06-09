<%--
  Created by IntelliJ IDEA.
  User: gimsangsu
  Date: 2022/06/10
  Time: 5:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    session.invalidate();
    response.sendRedirect("./main.jsp");
%>
