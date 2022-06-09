package com.proto.dao;

import com.proto.controller.DbController;
import com.proto.model.ScheduleDTO;
import com.proto.model.TodoDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO extends DbController {
    public TodoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // insert
    public boolean insertTodo(TodoDTO todo) throws SQLException {
        String query = "INSERT INTO todo (id, user_id, todo_time, content, subject, is_prior, is_homework, is_checked) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = this.getJdbcConnection().prepareStatement(query);
        statement.setInt(1, todo.getId());
        statement.setInt(2, todo.getUser_id());
        statement.setDate(3, new java.sql.Date(todo.getTodo_time().getTime()));
        statement.setString(4, todo.getContent());
        statement.setString(5, todo.getSubject());
        statement.setBoolean(6, todo.isIs_prior());
        statement.setBoolean(7, todo.isIs_homework());
        statement.setBoolean(8, todo.isIs_checked());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    // listAll
    public List<TodoDTO> listAllTodos() throws SQLException {
        List<TodoDTO> listTodos = new ArrayList<>();

        String query = "SELECT * FROM todo";

        connect();

        Statement statement = this.getJdbcConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            int user_id = resultSet.getInt("user_id");
            Date todo_time = resultSet.getDate("todo_time");
            String content = resultSet.getString("content");
            String subject = resultSet.getString("subject");
            boolean is_prior = resultSet.getBoolean("is_prior");
            boolean is_homework = resultSet.getBoolean("is_homework");
            boolean is_checked = resultSet.getBoolean("is_checked");

            TodoDTO todo = new TodoDTO(id, user_id, todo_time, content, subject, is_prior, is_homework, is_checked);
            listTodos.add(todo);
        }
        resultSet.close();
        statement.close();

        disconnect();

        return listTodos;
    }

    // delete 유저 아이디, 일자, 시작 시간, 끝나는 시간 이 필요해보이지만 일단은 아이디로 해보자.
    public boolean deleteTodo(TodoDTO todo) throws SQLException {
        String query = "DELETE FROM todo where id = ?";

        connect();

        PreparedStatement statement = this.getJdbcConnection().prepareStatement(query);
        statement.setInt(1, todo.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }
    // update
    public boolean updateTodo(TodoDTO todo) throws SQLException {
        String query = "UPDATE todo SET todo_time = ?, content = ?, is_checked = ?";
        query += " WHERE id = ?";
        connect();

        PreparedStatement statement = this.getJdbcConnection().prepareStatement(query);
        statement.setDate(1, new java.sql.Date(todo.getTodo_time().getTime()));
        statement.setString(2, todo.getContent());
        statement.setBoolean(3, todo.isIs_checked());
        statement.setInt(4, todo.getUser_id());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    // getById 그런게 필요할까?

}
