package com.github.fanzezhen.demo.sysbiz.foundation.entity;

import com.github.fanzezhen.common.mp.model.entity.tenant.BaseTenantGenericEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统用户角色表
 * </p>
 *
 * @author fanzezhen
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysUserRole对象", description="系统用户角色表")
public class SysUserRole extends BaseTenantGenericEntity {
    private static final long serialVersionUID = 1L;

    @Schema(name = "用户ID")
    private String userId;

    @Schema(name = "角色ID")
    private String roleId;

}
