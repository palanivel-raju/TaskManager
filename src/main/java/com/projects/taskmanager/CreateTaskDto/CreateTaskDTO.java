package com.projects.taskmanager.CreateTaskDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreateTaskDTO {
    private String title;
    private String description;
    private String deadline;
}
