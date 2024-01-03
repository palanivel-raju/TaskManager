package com.projects.taskmanager.services;

import com.projects.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class TaskService {
    private List<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;
    public TaskEntity addTask( String name, String desc, String deadline){
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setName(name);
        task.setDescription(desc);
        task.setDeadline(deadline);
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

}
