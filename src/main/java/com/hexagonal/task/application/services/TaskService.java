package com.hexagonal.task.application.services;

import com.hexagonal.task.domain.models.AdditionalTaskInfo;
import com.hexagonal.task.domain.models.Task;
import com.hexagonal.task.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class TaskService implements CreateTask, DeleteTask, RetrieveTask, UpdateTask, GetAdditionalTaskInfo {
  
  private final CreateTask createTask;
  private final DeleteTask deleteTask;
  private final RetrieveTask retrieveTask;
  private final UpdateTask updateTask;
  private final GetAdditionalTaskInfo getAdditionalTaskInfo;
  
  public TaskService(CreateTask createTask, DeleteTask deleteTask, RetrieveTask retrieveTask, UpdateTask updateTask, GetAdditionalTaskInfo getAdditionalTaskInfo) {
    this.createTask = createTask;
    this.deleteTask = deleteTask;
    this.retrieveTask = retrieveTask;
    this.updateTask = updateTask;
    this.getAdditionalTaskInfo = getAdditionalTaskInfo;
  }
  
  @Override
  public Task createTask(Task task) {
    return createTask.createTask(task);
  }
  
  @Override
  public Boolean deleteTask(Long id) {
    return deleteTask.deleteTask(id);
  }
  
  @Override
  public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
    return getAdditionalTaskInfo.getAdditionalTaskInfo(id);
  }
  
  @Override
  public Optional<Task> getTask(Long id) {
    return retrieveTask.getTask(id);
  }
  
  @Override
  public List<Task> getAllTasks() {
    return retrieveTask.getAllTasks();
  }
  
  @Override
  public Optional<Task> updateTask(Task updatedTask) {
    return updateTask.updateTask(updatedTask);
  }
}
