package com.github.fanzezhen.base.logbiz.facade;

import com.github.fanzezhen.common.log.foundation.entity.LogOperation;
import com.github.fanzezhen.common.log.foundation.entity.LogOperationDetail;

import java.util.Collection;

/**
 * @author zezhen.fan
 */
public interface LogOperationFacade {
    /**
     * 增
     *
     * @param logOperate 操作日志
     * @return 布尔
     */
    boolean addLogOperate(LogOperation logOperation);

    /**
     * 批量添加操作日志详情
     *
     * @param logOperateDetails 操作日志详情集合
     * @return 布尔
     */
    boolean addLogOperateDetailBatch(Collection<LogOperationDetail> logOperationDetailCollection);
}
