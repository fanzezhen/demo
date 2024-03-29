package com.github.fanzezhen.demo.sysbiz.foundation.entity;

import com.github.fanzezhen.common.mp.model.entity.tenant.BaseTenantGenericEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统角色表
 * </p>
 *
 * @author fanzezhen
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysRole对象", description="系统角色表")
public class SysRole extends BaseTenantGenericEntity {
    private static final long serialVersionUID = 1L;

    @Schema(name = "角色名")
    private String roleName;

    @Schema(name = "角色类型")
    private Integer roleType;

    @Schema(name = "释义")
    private String description;

    @Schema(name = "所属应用")
    private String appCode;

}
