package com.github.fanzezhen.demo.sysbiz.foundation.entity;

import com.github.fanzezhen.common.mp.model.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色权限关联表
 * </p>
 *
 * @author fanzezhen
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysRolePermission对象", description="角色权限关联表")
public class SysRolePermission extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Schema(name = "角色ID")
    private Long roleId;

    @Schema(name = "权限ID")
    private Long permissionId;


}
