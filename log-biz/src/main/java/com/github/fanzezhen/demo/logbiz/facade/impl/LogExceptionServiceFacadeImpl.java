package com.github.fanzezhen.demo.logbiz.facade.impl;

import com.github.fanzezhen.demo.logbiz.facade.LogExceptionServiceFacade;
import com.github.fanzezhen.demo.logbiz.foundation.service.ILogExceptionService;
import com.github.fanzezhen.demo.logbiz.model.dto.LogExceptionDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;


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
