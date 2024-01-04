package com.projects.taskmanager.CreateTaskDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUpdateTaskDTO {
    private String description;
    private String deadline;
    private Boolean completed;
}
