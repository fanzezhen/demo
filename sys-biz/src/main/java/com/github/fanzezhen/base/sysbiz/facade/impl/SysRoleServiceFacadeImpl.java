package com.github.fanzezhen.base.sysbiz.facade.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.fanzezhen.common.core.enums.CommonEnum;
import com.github.fanzezhen.common.core.model.dto.PageDto;
import com.github.fanzezhen.common.core.util.BeanConverterUtil;
import com.github.fanzezhen.base.sysbiz.facade.SysRoleServiceFacade;
import com.github.fanzezhen.base.sysbiz.foundation.entity.SysRole;
import com.github.fanzezhen.base.sysbiz.foundation.entity.SysUserRole;
import com.github.fanzezhen.base.sysbiz.foundation.service.ISysRoleService;
import com.github.fanzezhen.base.sysbiz.foundation.service.ISysUserRoleService;
import com.github.fanzezhen.base.sysbiz.model.dto.SysRoleDto;
import com.github.fanzezhen.base.sysbiz.model.vo.SysRoleVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author zezhen.fan
 */
@Service
public class SysRoleServiceFacadeImpl implements SysRoleServiceFacade {
    @Resource
    private ISysRoleService sysRoleService;
    @Resource
    private ISysUserRoleService sysUserRoleService;

    @Override
    public SysRoleVo getById(String id) {
        return toVo(sysRoleService.getById(id));
    }

    @Override
    public List<SysRoleVo> list() {
        return toVo(sysRoleService.list());
    }

    @Override
    public List<SysRoleVo> listValid() {
        return toVo(sysRoleService.list(new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getDelFlag, CommonEnum.DeleteFlagEnum.NO.getCode())));
    }

    @Override
    public List<Object> listIdObjByUserId(String userId) {
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(userId);
        return sysUserRoleService.listObjs(new LambdaQueryWrapper<>(sysUserRole).select(SysUserRole::getRoleId));
    }

    @Override
    public List<SysRoleVo> listByUserId(String userId) {
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(userId);
        Set<Object> roleIdSet = new HashSet<>(sysUserRoleService.listObjs(new LambdaQueryWrapper<>(sysUserRole).select(SysUserRole::getRoleId)));
        return roleIdSet.size() > 0 ? toVo(sysRoleService.list(new LambdaQueryWrapper<SysRole>().in(SysRole::getId, roleIdSet))) : new ArrayList<>();
    }

    @Override
    public IPage<SysRoleVo> page(PageDto<SysRoleDto, SysRole> pageDto) {
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>(pageDto.getParam());
        if (!StringUtils.isEmpty(pageDto.getStartDate())) {
            queryWrapper.ge(SysRole::getCreateTime, pageDto.getStartDate());
        }
        if (!StringUtils.isEmpty(pageDto.getEndDate())) {
            queryWrapper.le(SysRole::getCreateTime, pageDto.getEndDate());
        }
        if (!StringUtils.isEmpty(pageDto.getParam().getRoleName())) {
            queryWrapper.like(SysRole::getRoleName, pageDto.getParam().getRoleName());
        }
        pageDto.getParam().setRoleName(null);
        queryWrapper.orderByDesc(SysRole::getUpdateTime);
        return sysRoleService.page(pageDto, queryWrapper).convert(this::toVo);
    }

    private SysRoleVo toVo(SysRole sysRole) {
        if (sysRole == null) {
            return null;
        }
        return BeanConverterUtil.copy(sysRole, new SysRoleVo());
    }

    private List<SysRoleVo> toVo(Collection<SysRole> sysRoles) {
        if (sysRoles == null) {
            return null;
        }
        List<SysRoleVo> sysRoleVoList = new ArrayList<>();
        for (SysRole sysRole : sysRoles) {
            sysRoleVoList.add(toVo(sysRole));
        }
        return sysRoleVoList;
    }
}
