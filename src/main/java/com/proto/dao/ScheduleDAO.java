package com.proto.dao;

import com.proto.controller.DbController;
import com.proto.model.ScheduleDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO extends DbController {
    public ScheduleDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // insert
    public boolean insertSchedule(ScheduleDTO schedule) throws SQLException {
        String query = "INSERT INTO schedule (id, user_id, dayOfWeek, start_time, end_time, prof, building, room) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = this.getJdbcConnection().prepareStatement(query);
        statement.setInt(1, schedule.getId());
        statement.setString(2, schedule.getUser_id());
        statement.setInt(3, schedule.getDayOfWeek());
        statement.setInt(4, schedule.getStart_time());
        statement.setInt(5, schedule.getEnd_time());
        statement.setString(6, schedule.getProf());
        statement.setString(7, schedule.getBuilding());
        statement.setString(8, schedule.getRoom());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    // listAll
    public List<ScheduleDTO> listAllSchedules() throws SQLException {
        List<ScheduleDTO> listSchedule = new ArrayList<>();

        String query = "SELECT * FROM schedule";

        connect();

        Statement statement = this.getJdbcConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String user_id = resultSet.getString("user_id");
            int dayOfWeek = resultSet.getInt("dayOfWeek");
            int start_time = resultSet.getInt("start_time");
            int end_time = resultSet.getInt("end_time");
            String prof = resultSet.getString("prof");
            String building = resultSet.getString("building");
            String room = resultSet.getString("room");

            ScheduleDTO schedule = new ScheduleDTO(id, user_id, dayOfWeek, start_time, end_time, prof, building, room);
            listSchedule.add(schedule);
        }
        resultSet.close();
        statement.close();

        disconnect();

        return listSchedule;
    }

    // delete 유저 아이디, 일자, 시작 시간, 끝나는 시간 이 필요해보이지만 일단은 아이디로 해보자.
    public boolean deleteSchedule(ScheduleDTO schedule) throws SQLException {
        String query = "DELETE FROM schedule where id = ?";

        connect();

        PreparedStatement statement = this.getJdbcConnection().prepareStatement(query);
        statement.setInt(1, schedule.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }
    // upint
    public boolean upintSchedule(ScheduleDTO schedule) throws SQLException {
        String query = "UPint schedule SET dayOfWeek = ?, start_time = ?, end_time = ?";
        query += " WHERE id = ?";
        connect();

        PreparedStatement statement = this.getJdbcConnection().prepareStatement(query);
        statement.setInt(1, schedule.getDayOfWeek());
        statement.setInt(2, schedule.getEnd_time());
        statement.setInt(4, schedule.getStart_time());
        statement.setInt(4, schedule.getId());

        boolean rowUpintd = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpintd;
    }

    //
    public List<ScheduleDTO> getByUserName(String name) throws SQLException {
        List<ScheduleDTO> mySchedules = new ArrayList<>();
        String query = "SELECT * FROM schedule WHERE user_id = ?";

        connect();

        PreparedStatement statement = this.getJdbcConnection().prepareStatement(query);
        statement.setString(1, name);

        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()) {
            int id = resultSet.getInt("id");
            String user_id = resultSet.getString("user_id");
            int dayOfWeek = resultSet.getInt("dayOfWeek");
            int start_time = resultSet.getInt("start_time");
            int end_time = resultSet.getInt("end_time");
            String prof = resultSet.getString("prof");
            String building = resultSet.getString("building");
            String room = resultSet.getString("room");

            ScheduleDTO schedule = new ScheduleDTO(id, user_id, dayOfWeek, start_time, end_time, prof, building, room);
            mySchedules.add(schedule);
        }

        return mySchedules;
    }

    public ScheduleDTO getById(int id) throws SQLException {
    ScheduleDTO schedule = null;
    String query = "SELECT * FROM schedule WHERE id = ?";

    connect();

    PreparedStatement statement = this.getJdbcConnection().prepareStatement(query);
    statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()) {
            String user_id = resultSet.getString("user_id");
            int dayOfWeek = resultSet.getInt("dayOfWeek");
            int start_time = resultSet.getInt("start_time");
            int end_time = resultSet.getInt("end_time");
            String prof = resultSet.getString("prof");
            String building = resultSet.getString("building");
            String room = resultSet.getString("room");

            schedule = new ScheduleDTO(id, user_id, dayOfWeek, start_time, end_time, prof, building, room);
        }

        return schedule;

    }
}
