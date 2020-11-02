package com.github.fanzezhen.base.sysbiz.foundation.entity;

import com.github.fanzezhen.common.core.model.entity.BaseVarEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统字典表
 * </p>
 *
 * @author fanzezhen
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysDict extends BaseVarEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 字段全名（表名_字段名）
     */
    private String tableField;

    /**
     * 字典代码
     */
    private String dictCode;

    /**
     * 代码名称
     */
    private String dictName;

    /**
     * 详细说明
     */
    private String dictDesc;

    /**
     * 所属应用
     */
    private String appCode;

    /**
     * 排序优先级
     */
    private Integer orderNum;

    /**
     * 创建人ID
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
