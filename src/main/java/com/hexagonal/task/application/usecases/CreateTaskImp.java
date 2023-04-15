package com.hexagonal.task.application.usecases;

import com.hexagonal.task.domain.models.Task;
import com.hexagonal.task.domain.ports.in.CreateTask;
import com.hexagonal.task.domain.ports.out.TaskRepositoryPort;

public class CreateTaskImp implements CreateTask {
  
  private final TaskRepositoryPort taskRepositoryPort;
  
  
  public CreateTaskImp(TaskRepositoryPort taskRepositoryPort) {
    this.taskRepositoryPort = taskRepositoryPort;
  }
  
  @Override
  public Task createTask(Task task) {
    return taskRepositoryPort.save(task);
  }
}
