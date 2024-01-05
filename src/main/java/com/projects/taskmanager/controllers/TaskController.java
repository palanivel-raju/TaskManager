package com.projects.taskmanager.controllers;

import com.projects.taskmanager.CreateTaskDto.CreateTaskDTO;
import com.projects.taskmanager.CreateTaskDto.CreateTaskResponeDTO;
import com.projects.taskmanager.CreateTaskDto.CreateUpdateTaskDTO;
import com.projects.taskmanager.CreateTaskDto.ErrorResponseDTO;
import com.projects.taskmanager.entities.TaskEntity;
import com.projects.taskmanager.services.NoteService;
import com.projects.taskmanager.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping ("/tasks")
public class TaskController {
    private final TaskService taskService;
    private NoteService noteService;
    public TaskController(TaskService taskService, NoteService noteService){
        this.taskService = taskService;
        this.noteService = noteService;
    }
    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks(){
        var tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CreateTaskResponeDTO> getTaskById(@PathVariable Integer id){
        var task = taskService.getTaskById(id);
        var note = noteService.getNotesForTask(id);
        ModelMapper modelMapper = new ModelMapper();
        if(task == null){
            return ResponseEntity.notFound().build();
        }
        var taskResponse = modelMapper.map(task, CreateTaskResponeDTO.class);
        taskResponse.setNotes(note);
        return ResponseEntity.ok(taskResponse);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body) throws ParseException {
        var task = taskService.addTask(body.getTitle(),body.getDescription(),body.getDeadline());
        return ResponseEntity.ok(task);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable Integer id, @RequestBody CreateUpdateTaskDTO body) throws ParseException {
        var task = taskService.updateTask(id, body.getDescription(), body.getDeadline(), body.getCompleted());
        if(task == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleError(Exception e){
        if(e instanceof ParseException){
            return ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalid date format"));
        }
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Internal Server Error"));
    }

}
