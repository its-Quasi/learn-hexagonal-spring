package com.hexagonal.task.infrastructure.config;

import com.hexagonal.task.application.services.TaskService;
import com.hexagonal.task.application.usecases.*;
import com.hexagonal.task.domain.ports.in.GetAdditionalTaskInfo;
import com.hexagonal.task.domain.ports.out.ExternalServicePort;
import com.hexagonal.task.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.task.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonal.task.infrastructure.repositories.TaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
  
  @Bean
  public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfo getAdditionalTaskInfo) {
    return new TaskService(
            new CreateTaskImp(taskRepositoryPort),
            new DeleteTaskImp(taskRepositoryPort),
            new RetrieveTaskImp(taskRepositoryPort),
            new UpdateTaskImp(taskRepositoryPort),
            getAdditionalTaskInfo
    );
  }
  
  @Bean
  public TaskRepositoryPort taskRepositoryPort(TaskRepositoryAdapter taskRepositoryAdapter) {
    return taskRepositoryAdapter;
  }
  
  @Bean
  public GetAdditionalTaskInfoImp getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
    return new GetAdditionalTaskInfoImp(externalServicePort);
  }
  
  @Bean
  public ExternalServicePort externalServicePort() {
    return new ExternalServiceAdapter();
  }
  
}
