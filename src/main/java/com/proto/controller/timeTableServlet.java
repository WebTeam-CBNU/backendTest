package com.proto.controller;

import com.proto.dao.ScheduleDAO;
import com.proto.dao.UserDAO;
import com.proto.model.ScheduleDTO;
import com.proto.model.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/showTable")
public class timeTableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ScheduleDAO scheduleDAO;

    public void init(){
        String jdbcURL = "jdbc:mysql://localhost:3306/web2022_1"; // sql 설정할때 바꿔주기
        String jdbcUsername = "test2022";
        String jdbcPassword = "909012";

        scheduleDAO = new ScheduleDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            showTable(request, response);
        } catch (SQLException e) {
            System.out.println("this is Exception");
            throw new ServletException(e);
        }
    }

    private void showTable(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        HttpSession session = request.getSession();
        String name = session.getAttribute("userName").toString();
        List<ScheduleDTO> scList = scheduleDAO.getByUserName(name);

        System.out.println("fuck!");

        session.setAttribute("scheduleData", scList);

        List<ScheduleDTO> newSC = (List<ScheduleDTO>) session.getAttribute("scheduleData");

        System.out.println(newSC.get(0).getStart_time());

        response.sendRedirect("src/jspFriends/timetable.jsp");
    }
}
