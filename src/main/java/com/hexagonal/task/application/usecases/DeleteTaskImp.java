package com.hexagonal.task.application.usecases;

import com.hexagonal.task.domain.ports.in.DeleteTask;
import com.hexagonal.task.domain.ports.out.TaskRepositoryPort;

public class DeleteTaskImp implements DeleteTask {
  private final TaskRepositoryPort taskRepositoryPort;
  
  public DeleteTaskImp(TaskRepositoryPort taskRepositoryPort) {
    this.taskRepositoryPort = taskRepositoryPort;
  }
  
  @Override
  public Boolean deleteTask(Long id) {
    return taskRepositoryPort.deleteById(id);
  }
}
