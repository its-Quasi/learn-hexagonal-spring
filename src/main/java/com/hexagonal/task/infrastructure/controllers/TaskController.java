package com.hexagonal.task.infrastructure.controllers;

import com.hexagonal.task.application.services.TaskService;
import com.hexagonal.task.domain.models.AdditionalTaskInfo;
import com.hexagonal.task.domain.models.Task;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
  
  private final TaskService taskService;
  
  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }
  
  @PostMapping
  public ResponseEntity<Task> createTask(@RequestBody Task task){
    Task createdTask = taskService.createTask(task);
    return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Task> getTaskByid(@PathVariable Long id){
    Optional<Task> taskOpt = taskService.getTask(id);
    return taskOpt.map(task -> new ResponseEntity<>(task, HttpStatus.OK))
              .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  
  @GetMapping
  public ResponseEntity<List<Task>> getAllTasks(){
    List<Task> tasks = taskService.getAllTasks();
    return new ResponseEntity<>(tasks,HttpStatus.OK);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Task> updateTask(@RequestBody Task task){
    Optional<Task> taskOpt = taskService.updateTask(task);
    return new ResponseEntity<>(taskOpt.get(), HttpStatus.OK);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
    Boolean wasDeleted = taskService.deleteTask(id);
    if(wasDeleted){
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/{id}/addInfo")
  public ResponseEntity<AdditionalTaskInfo> getAdditionalTaskInfo(@PathVariable Long id){
    AdditionalTaskInfo ats = taskService.getAdditionalTaskInfo(id);
    return new ResponseEntity<>(ats, HttpStatus.OK);
  }
}
