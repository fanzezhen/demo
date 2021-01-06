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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zezhen.fan
 */
@Slf4j
@Service
public class SysUserServiceFacadeImpl implements SysUserServiceFacade {
    @Resource
    private ISysUserService sysUserService;
    @Resource
    private ISysUserRoleService sysUserRoleService;

    @Override
    public IPage<SysUserVo> page(PageDto<SysUserDto, SysUser> pageDto) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>(pageDto.getParam());
        if (!StringUtils.isEmpty(pageDto.getParam().getUsername())) {
            queryWrapper.like(SysUser::getUsername, pageDto.getParam().getUsername());
        }
        pageDto.getParam().setUsername(null);
        queryWrapper.orderByDesc(SysUser::getUpdateTime);
        return sysUserService.page(pageDto, queryWrapper).convert(this::toVo);
    }

    @Override
    public SysUserVo getById(String id) {
        return toVo(sysUserService.getById(id));
    }

    @Override
    public SysUserVo getByUserName(String username) {
        return toVo(sysUserService.getOne(new QueryWrapper<SysUser>().eq("username", username)));
    }

    @Override
    public SysUserVo getByUserName(String username, String appCode) {
        return toVo(sysUserService.getOne(
                new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username).eq(SysUser::getAppCode, appCode)));
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
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
        if (sysUser == null) {
            return null;
        }
        return BeanConverterUtil.copy(sysUser, new SysUserVo());
    }
}
