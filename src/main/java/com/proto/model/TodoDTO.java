package com.proto.model;

import java.util.Date;

public class TodoDTO {
    private int id;
    private int user_id;
    private Date todo_time;
    private String content;
    private String subject;
    private boolean is_prior;
    private boolean is_homework;
    private boolean is_checked;

    public TodoDTO(int id, int user_id, Date todo_time, String content, String subject, boolean is_prior, boolean is_homework, boolean is_checked) {
        this.id = id;
        this.user_id = user_id;
        this.todo_time = todo_time;
        this.content = content;
        this.subject = subject;
        this.is_prior = is_prior;
        this.is_homework = is_homework;
        this.is_checked = is_checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getTodo_time() {
        return todo_time;
    }

    public void setTodo_time(Date todo_time) {
        this.todo_time = todo_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isIs_prior() {
        return is_prior;
    }

    public void setIs_prior(boolean is_prior) {
        this.is_prior = is_prior;
    }

    public boolean isIs_homework() {
        return is_homework;
    }

    public void setIs_homework(boolean is_homework) {
        this.is_homework = is_homework;
    }

    public boolean isIs_checked() {
        return is_checked;
    }

    public void setIs_checked(boolean is_checked) {
        this.is_checked = is_checked;
    }
}
