package com.github.fanzezhen.base.logbiz.facade;

import com.github.fanzezhen.base.logbiz.model.dto.LogOperationDto;

public interface LogOperationServiceFacade {
    boolean add(LogOperationDto logOperationDto);
}
