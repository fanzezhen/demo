package com.github.fanzezhen.demo.sysbiz.foundation.entity;

import com.github.fanzezhen.common.mp.model.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="SysRole对象", description="系统角色表")
public class SysRole extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色名")
    private String roleName;

    @ApiModelProperty(value = "角色类型")
    private Integer roleType;

    @ApiModelProperty(value = "释义")
    private String description;

    @ApiModelProperty(value = "所属应用")
    private String appCode;

}
