package com.github.fanzezhen.demo.sysbiz.foundation.entity;

import com.github.fanzezhen.common.mp.model.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name="SysPermission对象", description="菜单、按钮表")
public class SysPermission extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Schema(name = "上级ID")
    private String pid;

    @Schema(name = "显示名称")
    private String displayName;

    @Schema(name = "请求地址")
    private String operationUrl;

    @Schema(name = "是否为菜单（1--菜单；2--按钮）")
    private Integer permissionType;

    @Schema(name = "排序优先级")
    private Integer orderNum;

    @Schema(name = "所属应用")
    private String appCode;

}
