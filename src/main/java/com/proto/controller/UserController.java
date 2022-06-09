package com.proto.controller;

import com.proto.dao.UserDAO;
import com.proto.model.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserController extends HttpServlet {
    private UserDAO userDAO;

    public void init(){
        String jdbcURL = "jdbc:mysql://localhost:3306/test2022"; // sql 설정할때 바꿔주기
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
        String action = request.getServletPath();

        System.out.println("get log from getting action");

        try {
            switch (action) {
                case "/insert":
                    insertUser(request, response);
                    break;
                default:
                    System.out.println("this is fucking new form list book");
                    break;
            }
        } catch (SQLException ex) {
            System.out.println("this is fucking Exception");
            throw new ServletException(ex);
        }
        System.out.println("hmm....");
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserDTO user = new UserDTO(name, password);
        userDAO.insertUser(user);
        response.sendRedirect("list");
    }

}
