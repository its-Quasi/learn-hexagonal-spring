package com.hexagonal.task.domain.models;

import javax.persistence.Id;
import java.time.LocalDateTime;

public class Task {
  private Long id;
  private String title;
  private String Description;
  private LocalDateTime creationDate;
  private Boolean completed;
  
  public Task(){}
  
  public Task(Long id, String title, String description, LocalDateTime creationDate, Boolean completed) {
    this.id = id;
    this.title = title;
    Description = description;
    this.creationDate = creationDate;
    this.completed = completed;
  }
  
  public Long getId() {
    return id;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getDescription() {
    return Description;
  }
  
  public void setDescription(String description) {
    Description = description;
  }
  
  public LocalDateTime getCreationDate() {
    return creationDate;
  }
  
  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }
  
  public Boolean getCompleted() {
    return completed;
  }
  
  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }
}
