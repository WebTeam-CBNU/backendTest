package com.proto.controller;

import com.proto.dao.UserDAO;
import com.proto.model.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/insert")
public class mainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init(){
        String jdbcURL = "jdbc:mysql://localhost:3306/test2022_1"; // sql 설정할때 바꿔주기
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
            insertUser(request, response);
        } catch (SQLException e) {
            System.out.println("this is fucking Exception");
            throw new ServletException(e);
        }

        System.out.println("fuck@");

        response.sendRedirect("main.jsp");
//        String action = request.getServletPath();
//
//        System.out.println("get log from getting action");
//
//        try {
//            switch (action) {
//                case "/insert":
//                    insertUser(request, response);
//                    break;
//                case "/login":
//                    LoginUser(request, response);
//                    break;
//                default:
//                    System.out.println("this is fucking new form list book");
//                    defaultMain(request, response);
//                    break;
//            }
//        } catch (SQLException ex) {
//            System.out.println("this is fucking Exception");
//            throw new ServletException(ex);
//        }
//        System.out.println("hmm....");
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserDTO user = new UserDTO(name, password);
        userDAO.insertUser(user);
    }

    private void LoginUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserDTO user = new UserDTO(name, password);
        userDAO.insertUser(user);
        response.sendRedirect("list");
    }

    private void defaultMain(HttpServletRequest request, HttpServletResponse response)
            throws SQLException,ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
        dispatcher.forward(request, response);
    }
}
