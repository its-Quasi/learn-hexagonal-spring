package com.hexagonal.task.application.usecases;

import com.hexagonal.task.domain.models.Task;
import com.hexagonal.task.domain.ports.in.UpdateTask;
import com.hexagonal.task.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskImp implements UpdateTask {
  
  private final TaskRepositoryPort taskRepositoryPort;
  
  public UpdateTaskImp(TaskRepositoryPort taskRepositoryPort) {
    this.taskRepositoryPort = taskRepositoryPort;
  }
  
  @Override
  public Optional<Task> updateTask(Task updatedTask) {
    return taskRepositoryPort.update(updatedTask);
  }
}
