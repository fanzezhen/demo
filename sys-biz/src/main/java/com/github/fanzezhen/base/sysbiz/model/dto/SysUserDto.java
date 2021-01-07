package com.github.fanzezhen.base.sysbiz.model.dto;

import com.github.fanzezhen.base.sysbiz.foundation.entity.SysUser;
import com.github.fanzezhen.common.core.annotion.OperateLog;
import com.github.fanzezhen.common.core.dict.SysUserDict;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Collection;

/**
 * @author zezhen.fan
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@OperateLog(dictClass = SysUserDict.class, tableName = "sys_user")
public class SysUserDto extends SysUser {
    private Collection<String> roleNames;
    private Collection<String> roleIds;
    private Collection<Integer> roleTypes;

}
