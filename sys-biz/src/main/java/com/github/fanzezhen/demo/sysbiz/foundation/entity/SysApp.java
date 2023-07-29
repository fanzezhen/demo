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
 * 系统应用表
 * </p>
 *
 * @author fanzezhen
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysApp对象", description="系统应用表")
public class SysApp extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Schema(name = "代码")
    private String appCode;

    @Schema(name = "名称")
    private String appName;

    @Schema(name = "状态（0--正常；1--停用）")
    @TableField(fill = FieldFill.INSERT)
    private Integer status;

    @Schema(name = "版本号")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @Version
    private Integer version;


}
