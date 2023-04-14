package com.hexagonal.task.domain.ports.out;

import com.hexagonal.task.domain.models.Task;

import java.util.Optional;
import java.util.List;

public interface TaskRepositoryPort {
  Task save(Task task);
  Optional<Task> findByid(Long id);
  List<Task> findAll();
  Optional<Task> update(Task task);
  Boolean deleteById(Long id);
}
