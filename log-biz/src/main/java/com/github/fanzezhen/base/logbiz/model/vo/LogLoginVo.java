package com.github.fanzezhen.base.logbiz.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogLoginVo {
    private String id;
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
    private LocalDateTime createTime;
    private String createUserId;
}
