package com.github.fanzezhen.base.sysbiz.foundation.entity;

import com.github.fanzezhen.common.core.model.entity.BaseVarEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单、按钮表
 * </p>
 *
 * @author fanzezhen
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysPermission对象", description="菜单、按钮表")
public class SysPermission extends BaseVarEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "上级ID")
    private String pid;

    @ApiModelProperty(value = "显示名称")
    private String displayName;

    @ApiModelProperty(value = "请求地址")
    private String operationUrl;

    @ApiModelProperty(value = "是否为菜单（1--菜单；2--按钮）")
    private Integer permissionType;

    @ApiModelProperty(value = "排序优先级")
    private Integer orderNum;

    @ApiModelProperty(value = "所属应用")
    private String appCode;

}
