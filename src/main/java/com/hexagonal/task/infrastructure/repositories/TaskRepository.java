package com.hexagonal.task.infrastructure.repositories;

import com.hexagonal.task.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}
