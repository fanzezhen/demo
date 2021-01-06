package com.github.fanzezhen.base.logbiz.facade.impl;

import com.github.fanzezhen.base.logbiz.facade.LogExceptionServiceFacade;
import com.github.fanzezhen.base.logbiz.foundation.service.ILogExceptionService;
import com.github.fanzezhen.base.logbiz.model.dto.LogExceptionDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zezhen.fan
 */
@Component
public class LogExceptionServiceFacadeImpl implements LogExceptionServiceFacade {
    @Resource
    private ILogExceptionService logExceptionService;

    @Override
    public boolean add(LogExceptionDto logExceptionDto) {
        return logExceptionService.save(logExceptionDto);
    }
}
