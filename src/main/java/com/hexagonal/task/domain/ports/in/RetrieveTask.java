package com.hexagonal.task.domain.ports.in;

import com.hexagonal.task.domain.models.Task;
import java.util.Optional;
import java.util.List;

public interface RetrieveTask {
  Optional<Task> getTask(Long id);
  List<Task> getAllTasks();
}
