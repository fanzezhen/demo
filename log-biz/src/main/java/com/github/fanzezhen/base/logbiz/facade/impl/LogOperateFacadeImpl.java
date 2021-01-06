package com.github.fanzezhen.base.logbiz.facade.impl;

import com.github.fanzezhen.base.logbiz.facade.LogOperateFacade;
import com.github.fanzezhen.base.logbiz.foundation.entity.LogOperate;
import com.github.fanzezhen.base.logbiz.foundation.entity.LogOperateDetail;
import com.github.fanzezhen.base.logbiz.foundation.service.ILogOperateDetailService;
import com.github.fanzezhen.base.logbiz.foundation.service.ILogOperateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author zezhen.fan
 */
@Service
public class LogOperateFacadeImpl implements LogOperateFacade {
    @Resource
    private ILogOperateService logOperateService;
    @Resource
    private ILogOperateDetailService logOperateDetailService;

    @Override
    public boolean addLogOperate(LogOperate logOperate) {
        return logOperateService.save(logOperate);
    }

    @Override
    public boolean addLogOperateDetailBatch(Collection<LogOperateDetail> logOperateDetails) {
        return logOperateDetailService.saveBatch(logOperateDetails);
    }
}
