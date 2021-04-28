package com.github.fanzezhen.base.sysbiz.foundation.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.github.fanzezhen.common.core.model.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 字典项
 * </p>
 *
 * @author fanzezhen
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysDictItem对象", description="字典项")
public class SysDictItem extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典ID")
    private String dictId;

    @ApiModelProperty(value = "字典代码")
    private String itemCode;

    @ApiModelProperty(value = "代码名称")
    private String itemName;

    @ApiModelProperty(value = "详细说明")
    private String remark;

    @ApiModelProperty(value = "排序优先级")
    private Integer orderNum;

    @ApiModelProperty(value = "所属应用")
    private String appCode;

    @ApiModelProperty(value = "状态（0--正常；1--停用）")
    @TableField(fill = FieldFill.INSERT)
    private Integer status;

    @ApiModelProperty(value = "版本号")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @Version
    private Integer version;


}