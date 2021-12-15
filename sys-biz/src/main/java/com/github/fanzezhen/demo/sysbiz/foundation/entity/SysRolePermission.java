package com.github.fanzezhen.demo.sysbiz.foundation.entity;

import com.github.fanzezhen.common.core.model.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="SysRolePermission对象", description="角色权限关联表")
public class SysRolePermission extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "权限ID")
    private Long permissionId;


}
