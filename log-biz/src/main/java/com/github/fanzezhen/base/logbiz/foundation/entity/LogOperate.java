package com.github.fanzezhen.base.logbiz.foundation.entity;

import com.github.fanzezhen.common.core.model.entity.BaseVarEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Index;
import javax.persistence.Table;

/**
 * <p>
 * 
 * </p>
 *
 * @author fanzezhen
 * @since 2021-01-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="LogOperate对象", description="操作日志")
@Table(indexes = {
        @Index(name = "ix_app_module_type", columnList = "APP_CODE, MODULE, OPERATE_TYPE")
})
public class LogOperate extends BaseVarEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "业务Id")
    private String bizId;

    @ApiModelProperty(value = "表名称")
    private String tableName;

    @ApiModelProperty(value = "操作类型")
    private Integer operateType;

    @ApiModelProperty(value = "操作来源")
    private Integer source;

    @ApiModelProperty(value = "操作模块")
    private Integer module;

    @ApiModelProperty(value = "IP地址")
    private String ipAddress;

    @ApiModelProperty(value = "设备号")
    private String deviceNum;

    @ApiModelProperty(value = "备注")
    private String comment;

    @ApiModelProperty(value = "操作人名称")
    private String operateUsername;

    @ApiModelProperty(value = "APP标识")
    private String appCode;


}
