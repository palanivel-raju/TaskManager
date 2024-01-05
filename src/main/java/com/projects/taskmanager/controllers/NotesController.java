package com.projects.taskmanager.controllers;

import com.projects.taskmanager.CreateTaskDto.CreateNotesDTO;
import com.projects.taskmanager.CreateTaskDto.CreateNotesResponseDTO;
import com.projects.taskmanager.entities.NoteEntity;
import com.projects.taskmanager.services.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.scripting.support.StaticScriptSource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {
    NoteService noteService;
    public NotesController(NoteService noteService){
        this.noteService = noteService;
    }

    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotesForTask(@PathVariable ("taskId") Integer taskId){
        var notes = noteService.getNotesForTask(taskId);

        return ResponseEntity.ok(notes);
    }

    @PostMapping("")
    public ResponseEntity<CreateNotesResponseDTO> addNote(@PathVariable ("taskId") Integer taskId,
                                                          @RequestBody CreateNotesDTO body){
        var note = noteService.addNote(taskId, body.getTitle(), body.getBody());
        return ResponseEntity.ok(new CreateNotesResponseDTO(taskId, note));
    }

}
