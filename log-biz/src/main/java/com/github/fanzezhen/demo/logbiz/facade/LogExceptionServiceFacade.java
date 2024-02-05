package com.github.fanzezhen.demo.logbiz.facade;


import com.github.fanzezhen.common.log.model.dto.ExceptionLogDto;

/**
 * @author zezhen.fan
 */
public interface LogExceptionServiceFacade {
    /**
     * 增
     *
     * @param logExceptionDto 异常日志信息
     * @return 布尔
     */
    boolean add(ExceptionLogDto logExceptionDto);
}
