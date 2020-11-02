package com.github.fanzezhen.base.sysbiz.foundation.entity;

import com.github.fanzezhen.common.core.model.entity.BaseVarEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户角色表
 * </p>
 *
 * @author fanzezhen
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysUserRole extends BaseVarEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 创建人ID
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
