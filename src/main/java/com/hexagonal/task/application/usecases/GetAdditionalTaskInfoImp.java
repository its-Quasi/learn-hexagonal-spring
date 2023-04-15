package com.hexagonal.task.application.usecases;

import com.hexagonal.task.domain.models.AdditionalTaskInfo;
import com.hexagonal.task.domain.ports.in.GetAdditionalTaskInfo;
import com.hexagonal.task.domain.ports.out.ExternalServicePort;

public class GetAdditionalTaskInfoImp implements GetAdditionalTaskInfo {
  
  private final ExternalServicePort externalServicePort;
  
  public GetAdditionalTaskInfoImp(ExternalServicePort externalServicePort) {
    this.externalServicePort = externalServicePort;
  }
  
  @Override
  public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
    return null;
  }
}
