package com.github.fanzezhen.base.sysbiz.facade.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.fanzezhen.common.core.model.dto.PageDto;
import com.github.fanzezhen.common.core.util.BeanConverterUtil;
import com.github.fanzezhen.base.sysbiz.facade.SysUserServiceFacade;
import com.github.fanzezhen.base.sysbiz.foundation.entity.SysUser;
import com.github.fanzezhen.base.sysbiz.foundation.entity.SysUserRole;
import com.github.fanzezhen.base.sysbiz.foundation.service.ISysUserRoleService;
import com.github.fanzezhen.base.sysbiz.foundation.service.ISysUserService;
import com.github.fanzezhen.base.sysbiz.model.dto.SysUserDto;
import com.github.fanzezhen.base.sysbiz.model.vo.SysUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SysUserServiceFacadeImpl implements SysUserServiceFacade {
    @Resource
    private ISysUserService sysUserService;
    @Resource
    private ISysUserRoleService sysUserRoleService;

    @Override
    public IPage<SysUserVo> page(PageDto<SysUserDto, SysUser> pageDto) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>(pageDto.getParam());
        if (!StringUtils.isEmpty(pageDto.getParam().getUsername())) {
            queryWrapper.like("username", pageDto.getParam().getUsername());
        }
        pageDto.getParam().setUsername(null);
        if (!StringUtils.isEmpty(pageDto.getStartDate())) queryWrapper.ge("create_time", pageDto.getStartDate());
        if (!StringUtils.isEmpty(pageDto.getEndDate())) queryWrapper.le("create_time", pageDto.getEndDate());
        queryWrapper.orderByDesc("update_time");
        return sysUserService.page(pageDto, queryWrapper).convert(this::toVo);
    }

    @Override
    public SysUserVo getById(String adminId) {
        return toVo(sysUserService.getById(adminId));
    }

    @Override
    public SysUserVo getByUserName(String username) {
        return toVo(sysUserService.getOne(new QueryWrapper<SysUser>().eq("username", username)));
    }

    @Override
    public SysUserVo save(SysUserDto sysUserDto) {
        if (sysUserService.saveOrUpdate(sysUserDto) && !org.springframework.util.StringUtils.isEmpty(sysUserDto.getId()) &&
                sysUserDto.getRoleIds() != null && sysUserDto.getRoleIds().size() > 0) {
            sysUserRoleService.remove(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, sysUserDto.getId()));
            List<SysUserRole> sysUserRoleList = new ArrayList<>();
            for (String roleId : sysUserDto.getRoleIds()) {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(sysUserDto.getId());
                sysUserRole.setRoleId(roleId);
                sysUserRoleList.add(sysUserRole);
            }
            sysUserRoleService.saveBatch(sysUserRoleList);
        }
        return toVo(sysUserDto);
    }

    private SysUserVo toVo(SysUser sysUser) {
        if (sysUser == null) return null;
        return BeanConverterUtil.copy(sysUser, new SysUserVo());
    }
}
