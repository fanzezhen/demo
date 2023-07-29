package com.github.fanzezhen.demo.sysbiz.foundation.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.github.fanzezhen.common.mp.model.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name="SysDictItem对象", description="字典项")
public class SysDictItem extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Schema(name = "字典ID")
    private String dictId;

    @Schema(name = "字典代码")
    private String itemCode;

    @Schema(name = "代码名称")
    private String itemName;

    @Schema(name = "详细说明")
    private String remark;

    @Schema(name = "排序优先级")
    private Integer orderNum;

    @Schema(name = "所属应用")
    private String appCode;

    @Schema(name = "状态（0--正常；1--停用）")
    @TableField(fill = FieldFill.INSERT)
    private Integer status;

    @Schema(name = "版本号")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @Version
    private Integer version;


}
