package com.github.fanzezhen.demo.sysbiz.model.dto;

import com.github.fanzezhen.demo.sysbiz.foundation.entity.SysUser;
import com.github.fanzezhen.common.core.annotion.OperateLog;
import com.github.fanzezhen.common.core.dict.SysUserDict;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Set;

/**
 * @author zezhen.fan
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@OperateLog(dictClass = SysUserDict.class, tableName = "sys_user")
public class SysUserDto extends SysUser {
    private Set<String> roleNames;
    private Set<String> roleIds;
    private Set<Integer> roleTypes;

}
