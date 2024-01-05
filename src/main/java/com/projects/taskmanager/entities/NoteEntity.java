package com.projects.taskmanager.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class NoteEntity {
    private int id;
    private String name;
    private String Body;

}
