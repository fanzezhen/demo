package com.github.fanzezhen.base.sysbiz.facade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.fanzezhen.base.sysbiz.foundation.entity.SysUser;
import com.github.fanzezhen.base.sysbiz.model.dto.SysUserDto;
import com.github.fanzezhen.base.sysbiz.model.vo.SysUserVo;
import com.github.fanzezhen.common.core.model.dto.PageDto;

public interface SysUserServiceFacade {
    IPage<SysUserVo> page(PageDto<SysUserDto, SysUser> pageDto);

    SysUserVo getById(String adminId);
    SysUserVo getByUserName(String username);
    SysUserVo getByUserName(String username, String appCode);
    SysUserVo save(SysUserDto sysUserDto);
}
