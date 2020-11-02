package com.github.fanzezhen.base.sysbiz.foundation.entity;

import com.github.fanzezhen.common.core.model.entity.BaseVarEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 菜单、按钮表
 * </p>
 *
 * @author fanzezhen
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysPermission extends BaseVarEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 上级ID
     */
    private String pid;

    /**
     * icon
     */
    private String icon;

    /**
     * 权限代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态（0--可用；1--未用）
     */
    private Integer status;

    /**
     * 请求地址
     */
    private String operationUrl;

    /**
     * 是否为菜单（1--菜单；2--按钮）
     */
    private Integer type;

    /**
     * 排序优先级
     */
    private Integer orderNum;

    /**
     * 是否删除（0--否；1--是）
     */
    private Integer delFlag;

    /**
     * 填表人ID
     */
    private String createUserId;

    /**
     * 最后更新人ID
     */
    private String updateUserId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 所属应用代码
     */
    private String appCode;


}
