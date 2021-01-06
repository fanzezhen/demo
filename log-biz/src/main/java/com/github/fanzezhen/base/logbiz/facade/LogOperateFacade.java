package com.github.fanzezhen.base.logbiz.facade;

import com.github.fanzezhen.base.logbiz.foundation.entity.LogOperate;
import com.github.fanzezhen.base.logbiz.foundation.entity.LogOperateDetail;

import java.util.Collection;

/**
 * @author zezhen.fan
 */
public interface LogOperateFacade {
    /**
     * 增
     *
     * @param logOperate 操作日志
     * @return 布尔
     */
    boolean addLogOperate(LogOperate logOperate);

    /**
     * 批量添加操作日志详情
     *
     * @param logOperateDetails 操作日志详情集合
     * @return 布尔
     */
    boolean addLogOperateDetailBatch(Collection<LogOperateDetail> logOperateDetails);
}
