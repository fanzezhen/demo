package com.github.fanzezhen.base.logbiz.facade.impl;

import com.github.fanzezhen.base.logbiz.facade.LogOperationServiceFacade;
import com.github.fanzezhen.common.log.foundation.service.ILogOperationService;
import com.github.fanzezhen.common.log.model.dto.LogOperationDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
