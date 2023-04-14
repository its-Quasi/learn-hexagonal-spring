package com.hexagonal.task.domain.ports.in;
//Imports
import com.hexagonal.task.domain.models.Task;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UpdateTask {
  Optional<Task> updateTask(Task updatedTask);
}
