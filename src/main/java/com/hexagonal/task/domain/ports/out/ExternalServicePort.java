package com.hexagonal.task.domain.ports.out;

import com.hexagonal.task.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
  AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
