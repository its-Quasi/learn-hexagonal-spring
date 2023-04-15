package com.hexagonal.task.infrastructure.repositories;

import com.hexagonal.task.domain.models.Task;
import com.hexagonal.task.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.task.infrastructure.entities.TaskEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TaskRepositoryAdapter implements TaskRepositoryPort {
  
  private final TaskRepository taskRepository;
  
  public TaskRepositoryAdapter(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }
  
  @Override
  public Task save(Task task) {
    TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
    Task createdTask = taskRepository.save(taskEntity).toDomainModel();
    return createdTask;
  }
  
  
  @Override
  public Optional<Task> findByid(Long id) {
     Optional<TaskEntity> taskEntityOptional = taskRepository.findById(id);
     Task searchedTask = taskEntityOptional.get().toDomainModel();
     return Optional.of(searchedTask);
  }
  
  @Override
  public List<Task> findAll() {
    return taskRepository.findAll().stream()
            .map(TaskEntity::toDomainModel)
            .collect(Collectors.toList());
  }
  
  @Override
  public Optional<Task> update(Task task) {
    if( taskRepository.existsById(task.getId()) ){
      TaskEntity toUpdate = TaskEntity.fromDomainModel(task);
      taskRepository.save(toUpdate);
      return Optional.of( toUpdate.toDomainModel() );
    }
    return Optional.empty();
  }
  
  @Override
  public Boolean deleteById(Long id) {
    if (taskRepository.existsById(id)) {
      taskRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
