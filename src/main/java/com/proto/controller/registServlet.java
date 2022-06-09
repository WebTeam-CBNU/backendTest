package com.proto.controller;

import com.proto.dao.UserDAO;
import com.proto.model.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.concurrent.TimeUnit;

@WebServlet("/registUser")
public class registServlet extends HttpServlet {
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

        PrintWriter out = response.getWriter();

        try {
            insertUser(request, response);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("fucl!");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('there are same id!');");
            out.println("location='src/jspFriends/main.jsp'");
            out.println("</script>");
        } catch (SQLException e) {
            System.out.println("this is fucking Exception");
            throw new ServletException(e);
        }

        System.out.println("fuck@");
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("regist_name");
        System.out.println(name);
        String password = request.getParameter("regist_password");
        System.out.println(password);

        UserDTO user = new UserDTO(name, password);
        userDAO.insertUser(user);

        response.sendRedirect("src/jspFriends/main.jsp");
    }
}
