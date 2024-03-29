package com.github.fanzezhen.demo.logbiz.facade;


import com.github.fanzezhen.demo.logbiz.model.dto.LogOperationDto;

/**
 * @author zezhen.fan
 */
public interface LogOperationServiceFacade {
    /**
     * 增
     * @param logOperationDto 操作日志DTO
     * @return 布尔
     */
    boolean add(LogOperationDto logOperationDto);
}
