package com.projects.taskmanager.CreateTaskDto;

import com.projects.taskmanager.entities.NoteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateTaskResponeDTO {
    private int id;
    private String name;
    private String description;
    private Date deadline;
    private boolean completed;
    private List<NoteEntity> notes;
}
