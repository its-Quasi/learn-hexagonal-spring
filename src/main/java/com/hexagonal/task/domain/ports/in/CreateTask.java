package com.hexagonal.task.domain.ports.in;
import com.hexagonal.task.domain.models.Task;

public interface CreateTask {
  Task createTask(Task task);
}
