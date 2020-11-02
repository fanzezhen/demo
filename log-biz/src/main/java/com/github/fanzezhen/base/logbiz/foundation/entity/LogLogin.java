package com.github.fanzezhen.base.logbiz.foundation.entity;

import com.github.fanzezhen.common.core.model.entity.BaseVarEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 登录日志表
 * </p>
 *
 * @author fanzezhen
 * @since 2020-06-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class LogLogin extends BaseVarEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 1--登录成功； 2--登录失败； 3--退出登录
     */
    private Integer logType;

    /**
     * ip
     */
    private String ip;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 浏览器名称
     */
    private String browserName;

    /**
     * 浏览器版本
     */
    private String browserVersion;

    /**
     * 备注
     */
    private String remark;

    /**
     * 应用代码
     */
    private String appCode;


}
