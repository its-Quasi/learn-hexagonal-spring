package com.hexagonal.task.application.usecases;

import com.hexagonal.task.domain.models.Task;
import com.hexagonal.task.domain.ports.in.RetrieveTask;
import com.hexagonal.task.domain.ports.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveTaskImp implements RetrieveTask {
  
  private final TaskRepositoryPort taskRepositoryPort;
  
  public RetrieveTaskImp(TaskRepositoryPort taskRepositoryPort) {
    this.taskRepositoryPort = taskRepositoryPort;
  }
  
  @Override
  public Optional<Task> getTask(Long id) {
    return taskRepositoryPort.findByid(id);
  }
  
  @Override
  public List<Task> getAllTasks() {
    return taskRepositoryPort.findAll();
  }
}
