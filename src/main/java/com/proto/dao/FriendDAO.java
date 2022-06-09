package com.proto.dao;

import com.proto.controller.DbController;
import com.proto.model.FriendDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FriendDAO extends DbController {
    public FriendDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // insert
    public boolean insertFriend(FriendDTO friend) throws SQLException {
        String query = "INSERT INTO friend (user_id, friend_id) VALUES (?, ?)";
        connect();

        PreparedStatement statement = this.getJdbcConnection().prepareStatement(query);
        statement.setInt(1, friend.getUser_id());
        statement.setInt(2, friend.getFriend_id());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    // listAll
    public List<FriendDTO> listAllFriends() throws SQLException {
        List<FriendDTO> friendDTOList = new ArrayList<>();

        String query = "SELECT * FROM friend";

        connect();

        Statement statement = this.getJdbcConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()) {
            int user_id = resultSet.getInt("user_id");
            int friend_id = resultSet.getInt("friend_id");

            FriendDTO friendDTO = new FriendDTO(user_id, friend_id);
            friendDTOList.add(friendDTO);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return friendDTOList;
    }
    // delete
    public boolean deleteFriend(FriendDTO friend) throws SQLException {

        String query = "DELETE FROM friend where user_id = ? AND  friend_id = ?";

        connect();

        PreparedStatement statement = this.getJdbcConnection().prepareStatement(query);
        statement.setInt(1, friend.getUser_id());
        statement.setInt(2, friend.getFriend_id());


        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }
    // update
    public boolean updateBook(FriendDTO friend, FriendDTO friend2) throws SQLException {
        String query = "UPDATE friend SET user_id = ?, friend_id = ?";
        query += " WHERE book_id = ? AND friend_id = ?";
        connect();

        PreparedStatement statement = this.getJdbcConnection().prepareStatement(query);
        statement.setInt(1, friend.getUser_id());
        statement.setInt(2, friend.getFriend_id());
        statement.setInt(3, friend2.getUser_id());
        statement.setInt(4, friend2.getFriend_id());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }
    // getById : x required

}
