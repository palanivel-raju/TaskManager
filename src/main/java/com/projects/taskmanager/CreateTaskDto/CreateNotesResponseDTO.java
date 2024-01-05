package com.projects.taskmanager.CreateTaskDto;

import com.projects.taskmanager.entities.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateNotesResponseDTO {
    private Integer taskId;
    private NoteEntity note;
}
