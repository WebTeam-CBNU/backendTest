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
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.concurrent.TimeUnit;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
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
            LoginUser(request, response);
        } catch (SQLException e) {
            System.out.println("this is fucking Exception");
            throw new ServletException(e);
        }
    }

    private void LoginUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("login_name");
        String password = request.getParameter("login_password");
        System.out.println("rq : " + password);

        UserDTO user = userDAO.getUserByName(name);
        String dbPassword = user.getPassword();
        System.out.println("db: " + user.getPassword());
        PrintWriter out = response.getWriter();

        if(password.equals(dbPassword)) {
            HttpSession session = request.getSession();
            session.setAttribute("userName", user.getName());
            response.sendRedirect("src/jspFriends/main.jsp");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('password incorrect!');");
            out.println("location='src/jspFriends/main.jsp'");
            out.println("</script>");
        }
    }
}
