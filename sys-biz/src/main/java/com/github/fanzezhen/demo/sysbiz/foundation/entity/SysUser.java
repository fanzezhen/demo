package com.github.fanzezhen.demo.sysbiz.foundation.entity;

import com.github.fanzezhen.common.mp.model.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author fanzezhen
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysUser对象", description="系统用户表")
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Schema(name = "用户名")
    private String username;

    @Schema(name = "密码")
    private String password;

    @Schema(name = "昵称")
    private String nickname;

    @Schema(name = "头像地址")
    private String avatar;

    @Schema(name = "邮箱")
    private String email;

    @Schema(name = "联系电话")
    private String phone;

    @Schema(name = "备注")
    private String remark;

    @Schema(name = "最后操作时间")
    private LocalDateTime lastTime;

}
