package com.github.fanzezhen.demo.logbiz.facade.impl;

import com.github.fanzezhen.demo.logbiz.facade.LogOperationServiceFacade;
import com.github.fanzezhen.demo.logbiz.foundation.service.ILogOperationService;
import com.github.fanzezhen.demo.logbiz.model.dto.LogOperationDto;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @author zezhen.fan
 */
@Component
public class LogOperationServiceFacadeImpl implements LogOperationServiceFacade {
    @Resource
    private ILogOperationService logOperationService;

    @Override
    public boolean add(LogOperationDto logOperationDto) {
        return logOperationService.save(logOperationDto);
    }
}
