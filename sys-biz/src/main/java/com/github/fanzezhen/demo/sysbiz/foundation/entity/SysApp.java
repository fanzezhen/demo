package com.github.fanzezhen.demo.sysbiz.foundation.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.github.fanzezhen.common.mp.model.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统应用表
 * </p>
 *
 * @author fanzezhen
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysApp对象", description="系统应用表")
public class SysApp extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "代码")
    private String appCode;

    @ApiModelProperty(value = "名称")
    private String appName;

    @ApiModelProperty(value = "状态（0--正常；1--停用）")
    @TableField(fill = FieldFill.INSERT)
    private Integer status;

    @ApiModelProperty(value = "版本号")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @Version
    private Integer version;


}
