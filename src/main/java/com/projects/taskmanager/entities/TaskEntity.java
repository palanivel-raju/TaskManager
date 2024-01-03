package com.projects.taskmanager.entities;

import lombok.Data;

import java.util.Date;
@Data
public class TaskEntity {
    private int id;
    private String name;
    private String description;
    private String deadline;
    private boolean completed;
}
