package com.github.fanzezhen.base.logbiz.facade.impl;

import com.github.fanzezhen.base.logbiz.facade.LogExceptionServiceFacade;
import com.github.fanzezhen.base.logbiz.foundation.service.ILogExceptionService;
import com.github.fanzezhen.base.logbiz.model.dto.LogExceptionDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LogExceptionServiceFacadeImpl implements LogExceptionServiceFacade {
    @Resource
    private ILogExceptionService LogExceptionService;

    @Override
    public boolean add(LogExceptionDto LogExceptionDto) {
        return LogExceptionService.save(LogExceptionDto);
    }
}
