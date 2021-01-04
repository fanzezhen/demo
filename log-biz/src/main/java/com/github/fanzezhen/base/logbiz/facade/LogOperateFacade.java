package com.github.fanzezhen.base.logbiz.facade;

import com.github.fanzezhen.base.logbiz.foundation.entity.LogOperate;
import com.github.fanzezhen.base.logbiz.foundation.entity.LogOperateDetail;

import java.util.Collection;

public interface LogOperateFacade {
    boolean addLogOperate(LogOperate logOperate);
    boolean addLogOperateDetailBatch(Collection<LogOperateDetail> logOperateDetails);
}
