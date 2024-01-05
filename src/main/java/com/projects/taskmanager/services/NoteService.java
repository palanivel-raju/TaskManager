package com.projects.taskmanager.services;

import com.projects.taskmanager.entities.NoteEntity;
import com.projects.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NoteService {
    TaskService taskService;
    HashMap<Integer, TasksNotesHolder> tasksNotesHolders = new HashMap<>();
    public NoteService(TaskService taskService){
        this.taskService = taskService;
    }
    class TasksNotesHolder{
        protected int noteid = 1;
        protected ArrayList<NoteEntity> notes = new ArrayList<>();
    }
    public List<NoteEntity> getNotesForTask(int taskId){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
        if(tasksNotesHolders.get(taskId) == null){
            tasksNotesHolders.put(taskId, new TasksNotesHolder());
        }
        return tasksNotesHolders.get(taskId).notes;
    }


    public NoteEntity addNote(int taskId, String title, String body){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
        if(tasksNotesHolders.get(taskId) == null){
            tasksNotesHolders.put(taskId, new TasksNotesHolder());
        }
        TasksNotesHolder tasksNotesHolder = tasksNotesHolders.get(taskId);
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setId(tasksNotesHolder.noteid);
        noteEntity.setName(title);
        noteEntity.setBody(body);
        tasksNotesHolder.notes.add(noteEntity);
        tasksNotesHolder.noteid++;
        return noteEntity;
    }


}
