package com.github.fanzezhen.base.sysbiz.foundation.entity;

import com.github.fanzezhen.common.core.model.entity.BaseVarEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author fanzezhen
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysUser extends BaseVarEntity {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 性别（0--女；1--男；2--未知的性别；3--未说明的性别）
     */
    private Integer sex;

    /**
     * 所属部门
     */
    private String department;

    /**
     * 是否删除（0--否；1--是）
     */
    private Integer delFlag;

    /**
     * 状态（0--正常；1--停用）
     */
    private Integer status;

    /**
     * 最后操作时间
     */
    private LocalDateTime lastTime;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 填表人ID
     */
    private String createUserId;

    /**
     * 最后更新人ID
     */
    private String updateUserId;

    /**
     * 所属应用代码
     */
    private String appCode;


}
