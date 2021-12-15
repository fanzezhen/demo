package com.github.fanzezhen.demo.sysbiz.facade.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.fanzezhen.common.core.constant.CommonConstant;
import com.github.fanzezhen.common.core.context.SysContext;
import com.github.fanzezhen.common.core.enums.auth.PermissionTypeEnum;
import com.github.fanzezhen.common.core.enums.db.DelFlagEnum;
import com.github.fanzezhen.common.core.util.BeanConverterUtil;
import com.github.fanzezhen.demo.sysbiz.facade.SysPermissionServiceFacade;
import com.github.fanzezhen.demo.sysbiz.facade.SysUserServiceFacade;
import com.github.fanzezhen.demo.sysbiz.foundation.entity.SysPermission;
import com.github.fanzezhen.demo.sysbiz.foundation.entity.SysRolePermission;
import com.github.fanzezhen.demo.sysbiz.foundation.entity.SysUserRole;
import com.github.fanzezhen.demo.sysbiz.foundation.service.ISysPermissionService;
import com.github.fanzezhen.demo.sysbiz.foundation.service.ISysRolePermissionService;
import com.github.fanzezhen.demo.sysbiz.foundation.service.ISysUserRoleService;
import com.github.fanzezhen.demo.sysbiz.model.vo.SysPermissionVo;
import com.github.fanzezhen.demo.sysbiz.model.vo.SysUserVo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zezhen.fan
 */
@Service
public class SysPermissionServiceFacadeImpl implements SysPermissionServiceFacade {
    @Resource
    private ISysPermissionService sysPermissionService;
    @Resource
    private SysUserServiceFacade sysUserServiceFacade;
    @Resource
    private ISysUserRoleService sysUserRoleService;
    @Resource
    private ISysRolePermissionService sysRolePermissionService;

    @Override
    public List<SysPermissionVo> listAllPermission() {
        return toVo(sysPermissionService.list());
    }

    @Override
    public List<SysPermissionVo> listPermissionByRoleId(String roleId) {
        return toVo(sysPermissionService.list());
    }

    @Override
    public List<SysPermissionVo> listPermissionByRoleIds(List<String> roleIds) {
        List<SysPermissionVo> sysPermissionVoList = new ArrayList<>();
        if (CollectionUtils.isEmpty(roleIds)) {
            return sysPermissionVoList;
        }
        List<Object> permissionIdObjList = sysRolePermissionService.listObjs(new LambdaQueryWrapper<SysRolePermission>()
                .select(SysRolePermission::getPermissionId).in(SysRolePermission::getRoleId, roleIds));
        if (CollectionUtils.isEmpty(permissionIdObjList)) {
            return sysPermissionVoList;
        }
        sysPermissionVoList = toVo(sysPermissionService.list(
                new LambdaQueryWrapper<SysPermission>().in(SysPermission::getId, permissionIdObjList)));
        return sysPermissionVoList;
    }

    @Override
    public List<SysPermissionVo> listPermissionByUserId(String userId) {
        return null;
    }

    @Override
    public List<Object> listLoginUserPermissionId() {
        List<Object> permissionIdList = new ArrayList<>();
        // 获取security登录用户
        String userName = SysContext.getUserName();
        if (StrUtil.isBlank(userName)) {
            return permissionIdList;
        }
        // 根据登录用户名查询用户
        SysUserVo sysUserVo = sysUserServiceFacade.getByUserName(userName);
        if (sysUserVo == null) {
            return permissionIdList;
        }
        // 根据用户ID查询角色ID集合
        List<Object> roleIdList = sysUserRoleService.listObjs(new LambdaQueryWrapper<SysUserRole>()
                .select(SysUserRole::getRoleId).eq(SysUserRole::getUserId, sysUserVo.getId()));
        if (roleIdList.size() <= 0) {
            return permissionIdList;
        }
        // 根据角色ID集合查询权限ID集合
        permissionIdList = sysRolePermissionService.listObjs(new LambdaQueryWrapper<SysRolePermission>()
                .select(SysRolePermission::getPermissionId).in(SysRolePermission::getRoleId, roleIdList));
        return permissionIdList;
    }

    @Override
    public List<SysPermissionVo> listLoginUserPermission() {
        List<SysPermissionVo> sysPermissionVoList = new ArrayList<>();
        List<Object> permissionIdList = listLoginUserPermissionId();
        if (permissionIdList.size() <= 0) {
            return sysPermissionVoList;
        }
        // 根据权限ID集合查询权限集合
        sysPermissionVoList = toVo(sysPermissionService.list(
                new LambdaQueryWrapper<SysPermission>().in(SysPermission::getId, permissionIdList)));
        return sysPermissionVoList;
    }

    @Override
    public List<SysPermissionVo> listLoginUserMenuPermission() {
        List<Object> permissionIdList = listLoginUserPermissionId();
        return listByTypeAndIdList(PermissionTypeEnum.MENU, permissionIdList);
    }

    @Override
    public List<SysPermissionVo> listMenuPermissionByUserId(String userId) {
        List<SysPermissionVo> sysPermissionVoList = new ArrayList<>();
        // 根据用户ID查询角色ID集合
        List<Object> roleIdList = sysUserRoleService.listObjs(new LambdaQueryWrapper<SysUserRole>()
                .select(SysUserRole::getRoleId).eq(SysUserRole::getUserId, userId));
        if (roleIdList.size() <= 0) {
            return sysPermissionVoList;
        }
        // 根据角色ID集合查询权限ID集合
        List<Object> permissionIdList = sysRolePermissionService.listObjs(new LambdaQueryWrapper<SysRolePermission>()
                .select(SysRolePermission::getPermissionId).in(SysRolePermission::getRoleId, roleIdList));
        return listByTypeAndIdList(PermissionTypeEnum.MENU, permissionIdList);
    }

    @Override
    public List<SysPermissionVo> listAllPermission(String appCode) {
        return toVo(sysPermissionService.list());
    }

    @Override
    public List<SysPermissionVo> listByTypeAndIdList(PermissionTypeEnum typeEnum, Collection<Object> permissionIds) {
        List<SysPermissionVo> sysPermissionVoList = new ArrayList<>();
        if (CollUtil.isEmpty(permissionIds)) {
            return sysPermissionVoList;
        }
        // 根据权限ID集合查询权限集合
        sysPermissionVoList = toVo(sysPermissionService.list(new LambdaQueryWrapper<SysPermission>()
                .eq(SysPermission::getPermissionType, typeEnum.getType())
                .in(SysPermission::getId, permissionIds)
                .orderByAsc(SysPermission::getOrderNum)));
        return sysPermissionVoList;
    }

    @Override
    public List<SysPermissionVo> listPermissionTree() {
        LambdaQueryWrapper<SysPermission> sysPermissionQueryWrapper = new LambdaQueryWrapper<SysPermission>()
                .eq(SysPermission::getDelFlag, DelFlagEnum.NOT_DELETED.code);
        return initPermissionTree(CommonConstant.PERMISSION_DEFAULT_PID, sysPermissionService.list(sysPermissionQueryWrapper));
    }

    @Override
    public List<SysPermissionVo> listPermissionTree(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return new ArrayList<>();
        }
        List<SysPermissionVo> sysPermissionVoList = new ArrayList<>();
        List<Object> permissionIdList = listIdObjByUserId(userId);
        if (permissionIdList.size() <= 0) {
            return sysPermissionVoList;
        }
        // 根据权限ID集合查询权限集合
        LambdaQueryWrapper<SysPermission> sysPermissionQueryWrapper = new LambdaQueryWrapper<SysPermission>()
                .eq(SysPermission::getDelFlag, DelFlagEnum.NOT_DELETED.code)
                .in(SysPermission::getId, permissionIdList)
                .orderByAsc(SysPermission::getOrderNum);
        return initPermissionTree(CommonConstant.PERMISSION_DEFAULT_PID, sysPermissionService.list(sysPermissionQueryWrapper));
    }

    private SysPermissionVo toVo(SysPermission sysPermission) {
        if (sysPermission == null) {
            return null;
        }
        return BeanConverterUtil.copy(sysPermission, new SysPermissionVo());
    }

    private List<SysPermissionVo> toVo(Collection<SysPermission> sysPermissions) {
        List<SysPermissionVo> sysPermissionVoList = new ArrayList<>();
        for (SysPermission sysPermission : sysPermissions) {
            sysPermissionVoList.add(toVo(sysPermission));
        }
        return sysPermissionVoList;
    }

    private List<Object> listIdObjByUserId(String userId) {
        List<Object> permissionIdList = new ArrayList<>();
        // 根据用户ID查询角色ID集合
        List<Object> roleIdList = sysUserRoleService.listObjs(new LambdaQueryWrapper<SysUserRole>()
                .select(SysUserRole::getRoleId).eq(SysUserRole::getUserId, userId));
        if (roleIdList.size() <= 0) {
            return permissionIdList;
        }
        // 根据角色ID集合查询权限ID集合
        permissionIdList = sysRolePermissionService.listObjs(new LambdaQueryWrapper<SysRolePermission>()
                .select(SysRolePermission::getPermissionId).in(SysRolePermission::getRoleId, roleIdList));
        return permissionIdList;
    }

    private List<SysPermissionVo> initPermissionTree(String pid, List<SysPermission> sysPermissionList) {
        List<SysPermissionVo> sysPermissionDetailList = new ArrayList<>();
        for (SysPermission sysPermission : sysPermissionList) {
            if (pid.equals(sysPermission.getPid())) {
                SysPermissionVo sysPermissionVo = toVo(sysPermission);
                sysPermissionVo.setChildList(initPermissionTree(sysPermissionVo.getId(), sysPermissionList));
                sysPermissionDetailList.add(sysPermissionVo);
            }
        }
        return sysPermissionDetailList;
    }
}
