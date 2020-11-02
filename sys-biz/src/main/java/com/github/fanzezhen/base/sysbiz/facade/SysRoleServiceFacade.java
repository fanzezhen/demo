package com.github.fanzezhen.base.sysbiz.facade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.fanzezhen.base.sysbiz.foundation.entity.SysRole;
import com.github.fanzezhen.base.sysbiz.model.dto.SysRoleDto;
import com.github.fanzezhen.base.sysbiz.model.vo.SysRoleVo;
import com.github.fanzezhen.common.core.model.dto.PageDto;

import java.util.List;

public interface SysRoleServiceFacade {
    SysRoleVo getById(String id);
    List<SysRoleVo> list();
    List<SysRoleVo> listValid();
    List<Object> listIdObjByUserId(String userId);
    List<SysRoleVo> listByUserId(String userId);
    IPage<SysRoleVo> page(PageDto<SysRoleDto, SysRole> pageDto);
}
