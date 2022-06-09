package com.proto.controller;

import com.proto.dao.UserDAO;
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

@WebServlet("/login")
public class timeTableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init(){
        String jdbcURL = "jdbc:mysql://localhost:3306/web2022_1"; // sql 설정할때 바꿔주기
        String jdbcUsername = "test2022";
        String jdbcPassword = "909012";

        userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
            System.out.println("this is fucking Exception");
            throw new ServletException(e);
        }
    }

    private void showTable(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {


    }
}
