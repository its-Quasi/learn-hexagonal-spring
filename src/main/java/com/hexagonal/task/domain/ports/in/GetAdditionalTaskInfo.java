package com.hexagonal.task.domain.ports.in;

import com.hexagonal.task.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfo {
  AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
