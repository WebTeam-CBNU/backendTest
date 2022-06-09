package com.proto.dao;

import com.proto.controller.DbController;
import com.proto.model.UserDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DbController {
    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // insert
    public boolean insertUser(UserDTO user) throws SQLException {
        String query = "INSERT INTO user (name, password) VALUES (?, ?)";
        connect();

        PreparedStatement statement = this.getJdbcConnection().prepareStatement(query);
        statement.setString(1, user.getName());
        statement.setString(2, user.getPassword());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    // listAll
    public List<UserDTO> listAllUsers() throws SQLException {
        List<UserDTO> listUsers = new ArrayList<>();
        String query = "SELECT * FROM user";

        connect();

        Statement statement = this.getJdbcConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");

            UserDTO user = new UserDTO(id, name, password);
            listUsers.add(user);
        }
        resultSet.close();
        statement.close();

        disconnect();

        return listUsers;
    }
    //
    public boolean deleteUser(UserDTO user) throws SQLException {
        String query = "DELETE FROM user where name = ?";

        connect();

        PreparedStatement statement = this.getJdbcConnection().prepareStatement(query);
        statement.setString(1, user.getName());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }
    // update x require

    // getByName
    public UserDTO getUserByName(String name) throws SQLException {
        UserDTO user = null;
        String query = "SELECT * FROM user WHERE name = ?";

        connect();

        PreparedStatement statement = this.getJdbcConnection().prepareStatement(query);
        statement.setString(1, name);

        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()){
            int id = resultSet.getInt("id");
            String password = resultSet.getString("password");

            user = new UserDTO(id, name, password);
        }

        resultSet.close();
        statement.close();

        return user;
    }

}
