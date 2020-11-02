package com.github.fanzezhen.base.logbiz.foundation.entity;

import com.github.fanzezhen.common.core.model.entity.BaseVarEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 异常日志表
 * </p>
 *
 * @author fanzezhen
 * @since 2020-06-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class LogException extends BaseVarEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 日志类型
     */
    private Integer logType;

    /**
     * 资源所属模块
     */
    private String modular;

    /**
     * 错误类名
     */
    private String className;

    /**
     * 错误说明
     */
    private String message;

    /**
     * 错误堆栈
     */
    private String stackTrace;

    /**
     * 应用代码
     */
    private String appCode;


}
