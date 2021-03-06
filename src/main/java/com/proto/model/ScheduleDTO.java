package com.proto.model;

public class ScheduleDTO {
    private int id;
    private String user_id;
    private int dayOfWeek;
    private int start_time;
    private int end_time;
    private String prof;
    private String building;
    private String room;

    public ScheduleDTO(int id, String user_id, int dayOfWeek, int start_time, int end_time, String prof, String building, String room) {
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

    public String getUser_id() {
        return user_id;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getStart_time() {
        return start_time;
    }

    public int getEnd_time() {
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
