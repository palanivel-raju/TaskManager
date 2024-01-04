package com.projects.taskmanager.services;

import com.projects.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
@Repository
public class TaskService {
    private List<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;
    private SimpleDateFormat deadlineformater = new SimpleDateFormat("yyyy-MM-dd");
    public TaskEntity addTask( String name, String desc, String deadline) throws ParseException {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setName(name);
        task.setDescription(desc);
        task.setDeadline(deadlineformater.parse(deadline));
        task.setCompleted(false);
        tasks.add(task);
        taskId++;
        return task;
    }
    public List<TaskEntity> getTasks(){
        return tasks;
    }
    public TaskEntity getTaskById(int id){
//        tasks.stream().findAny().filter(task -> task.getId() == id).orElse(null);
        for(TaskEntity taskEntity : tasks){
            if(taskEntity.getId() == id){
                return taskEntity;
            }
        }
        return null;
    }
    public TaskEntity updateTask(int id, String description, String deadline, Boolean completed) throws ParseException {
        TaskEntity task = getTaskById(id);
        if(task == null){
            return null;
        }
        if(description != null){
            task.setDescription(description);
        }
        if(deadline != null){
            task.setDeadline(deadlineformater.parse(deadline));
        }
        if(completed != null){
            task.setCompleted(completed);
        }
        return task;
    }

}
