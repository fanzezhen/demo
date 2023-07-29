package com.github.fanzezhen.demo.logbiz.facade.impl;

import com.github.fanzezhen.demo.logbiz.facade.LogOperationFacade;
import com.github.fanzezhen.common.log.foundation.entity.LogOperation;
import com.github.fanzezhen.common.log.foundation.entity.LogOperationDetail;
import com.github.fanzezhen.common.log.foundation.service.ILogOperationDetailService;
import com.github.fanzezhen.common.log.foundation.service.ILogOperationService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.Collection;

/**
 * @author zezhen.fan
 */
@Service
public class LogOperationFacadeImpl implements LogOperationFacade {
    @Resource
    private ILogOperationService logOperateService;
    @Resource
    private ILogOperationDetailService logOperateDetailService;

    @Override
    public boolean addLogOperate(LogOperation logOperate) {
        return logOperateService.save(logOperate);
    }

    @Override
    public boolean addLogOperateDetailBatch(Collection<LogOperationDetail> logOperateDetails) {
        return logOperateDetailService.saveBatch(logOperateDetails);
    }
}
