package com.github.fanzezhen.demo.logbiz.foundation.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.github.fanzezhen.common.mp.enums.log.ExceptionTypeEnum;
import com.github.fanzezhen.common.mp.model.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * <p>
 * 异常日志表
 * </p>
 *
 * @author fanzezhen
 * @since 2020-06-11
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table(indexes = {
        @Index(name = "ix_del_app_time", columnList = "del_flag, app_code, update_time")
})
public class LogException extends BaseEntity {
    /**
     * 日志类型
     */
    @EnumValue
    @Column(name = "LOG_TYPE", columnDefinition = "tinyint default 0 comment '日志类型'")
    @Schema(name = "日志类型")
    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
    private ExceptionTypeEnum logType;

    @Schema(name = "资源所属模块")
    @Column(name = "modular", columnDefinition = "varchar(100) null comment '资源所属模块'")
    private String modular;

    @Schema(name = "错误类名")
    @Column(name = "class_name", columnDefinition = "varchar(100) null comment '错误类名'")
    private String className;

    @Schema(name = "错误说明")
    @Column(name = "message", columnDefinition = "varchar(5000) null comment '错误说明'")
    private String message;

    @Schema(name = "错误堆栈")
    @Column(name = "stack_trace", columnDefinition = "text null comment '错误堆栈'")
    private String stackTrace;

    @Schema(name = "操作人名称")
    @Column(name = "operation_username", columnDefinition = "varchar(100) null comment '操作人名称'")
    private String operationUsername;

    @Schema(name = "应用代码")
    @Column(name = "app_code", columnDefinition = "varchar(50) null comment '应用代码'")
    private String appCode;

}
