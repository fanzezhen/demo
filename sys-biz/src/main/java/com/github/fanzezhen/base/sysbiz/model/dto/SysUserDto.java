package com.github.fanzezhen.base.sysbiz.model.dto;

import com.github.fanzezhen.base.sysbiz.foundation.entity.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class SysUserDto extends SysUser {
    private Collection<String> roleNames;
    private Collection<String> roleIds;
    private Collection<Integer> roleTypes;

}
