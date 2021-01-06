package com.github.fanzezhen.base.sysbiz.facade;

import com.github.fanzezhen.base.sysbiz.model.vo.SysPermissionVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zezhen.fan
 */
public interface SysPermissionServiceFacade {
    /**
     * 获取所有权限
     *
     * @return 列表
     */
    List<SysPermissionVo> listAllPermission();

    /**
     * 获取角色下的所有权限
     *
     * @param roleId 角色ID
     * @return 列表
     */
    List<SysPermissionVo> listPermissionByRoleId(@RequestParam("roleId") String roleId);

    /**
     * 获取角色下的所有权限
     *
     * @param roleIds 角色ID集合
     * @return 列表
     */
    List<SysPermissionVo> listPermissionByRoleIds(@RequestParam("roleIds") List<String> roleIds);

    /**
     * 获取用户下的所有权限
     *
     * @param userId 用户ID
     * @return 列表
     */
    List<SysPermissionVo> listPermissionByUserId(@RequestParam("userId") String userId);

    /**
     * 获取登录用户下的所有权限ID
     *
     * @return 权限ID列表
     */
    List<Object> listLoginUserPermissionId();


    /**
     * 获取登录用户下的所有权限
     *
     * @return 权限列表
     */
    List<SysPermissionVo> listLoginUserPermission();

    /**
     * 获取登录用户下的所有菜单权限
     *
     * @return 菜单权限列表
     */
    List<SysPermissionVo> listLoginUserMenuPermission();

    /**
     * 根据用户ID获取用户下的所有菜单权限
     *
     * @param userId 用户ID
     * @return 菜单权限列表
     */
    List<SysPermissionVo> listMenuPermissionByUserId(String userId);

    /**
     * 获取app下的所有权限
     *
     * @param appCode 应用标识
     * @return 权限列表
     */
    List<SysPermissionVo> listAllPermission(@RequestParam("appCode") String appCode);

    /**
     * 权限树
     *
     * @return 权限列表
     */
    List<SysPermissionVo> listPermissionTree();

    /**
     * 权限树
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    List<SysPermissionVo> listPermissionTree(String userId);
}
