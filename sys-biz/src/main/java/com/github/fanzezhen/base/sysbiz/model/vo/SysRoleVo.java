package com.github.fanzezhen.base.sysbiz.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author zezhen.fan
 */
@Data
@Accessors(chain = true)
public class SysRoleVo {
    private String id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色代码
     */
    private String roleCode;

    /**
     * 角色类型
     */
    private Integer roleType;

    /**
     * 是否删除（0--否；1--是）
     */
    private Integer delFlag;

    /**
     * 释义
     */
    private String description;

    /**
     * 状态（0--正常；1--停用）
     */
    private Integer status;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 填表人ID
     */
    private String createUserId;

    /**
     * 最后更新人ID
     */
    private String updateUserId;

    /**
     * 所属应用代码
     */
    private String appCode;
}
