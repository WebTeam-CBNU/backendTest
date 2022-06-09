package com.proto.model;

import java.util.Date;

public class ScheduleDTO {
    private int id;
    private int user_id;
    private int dayOfWeek;
    private Date start_time;
    private Date end_time;
    private String prof;
    private String building;
    private String room;

    public ScheduleDTO(int id, int user_id, int dayOfWeek, Date start_time, Date end_time, String prof, String building, String room) {
        this.id = id;
        this.user_id = user_id;
        this.dayOfWeek = dayOfWeek;
        this.start_time = start_time;
        this.end_time = end_time;
        this.prof = prof;
        this.building = building;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public Date getStart_time() {
        return start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public String getProf() {
        return prof;
    }

    public String getBuilding() {
        return building;
    }

    public String getRoom() {
        return room;
    }
}
