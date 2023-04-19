package com.hexagonal.task.infrastructure.entities;

import com.hexagonal.task.domain.models.Task;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
public class TaskEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String description;
  private LocalDateTime creationDate;
  private Boolean completed;
  
  public TaskEntity(){}
  
  public TaskEntity(Long id, String title, String description, LocalDateTime creationDate, Boolean completed) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.creationDate = creationDate;
    this.completed = completed;
  }
  
  public static TaskEntity fromDomainModel(Task task){
    return new TaskEntity(task.getId(), task.getTitle(), task.getDescription(), task.getCreationDate(), task.getCompleted());
  }
  
  
  public Task toDomainModel() {
    return new Task(this.id, this.title, this.description, this.creationDate, this.completed);
  }
}
