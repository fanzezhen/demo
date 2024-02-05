package com.github.fanzezhen.demo.logbiz.facade.impl;

import com.github.fanzezhen.common.log.model.dto.ExceptionLogDto;
import com.github.fanzezhen.demo.logbiz.facade.LogExceptionServiceFacade;
import com.github.fanzezhen.common.log.foundation.service.ILogExceptionService;
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
    public boolean add(ExceptionLogDto logExceptionDto) {
        return logExceptionService.save(logExceptionDto);
    }
}
