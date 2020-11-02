package com.github.fanzezhen.base.sysbiz.facade;

import com.github.fanzezhen.base.sysbiz.model.vo.SysPermissionVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SysPermissionServiceFacade {
    /**
     * 获取所有权限
     *
     * @return
     */
    List<SysPermissionVo> listPermission();

    /**
     * 获取角色下的所有权限
     *
     * @param roleId
     * @return
     */
    List<SysPermissionVo> listPermissionByRoleId(@RequestParam("roleId") String roleId);

    /**
     * 获取角色下的所有权限
     *
     * @param roleIds
     * @return
     */
    List<SysPermissionVo> listPermissionByRoleIds(@RequestParam("roleIds") List<String> roleIds);

    /**
     * 获取用户下的所有权限
     *
     * @param userId
     * @return
     */
    List<SysPermissionVo> listPermissionByUserId(@RequestParam("userId") String userId);

    /**
     * 获取登录用户下的所有权限ID
     *
     * @return
     */
    List<Object> listLoginUserPermissionId();


    /**
     * 获取登录用户下的所有权限
     *
     * @return
     */
    List<SysPermissionVo> listLoginUserPermission();

    /**
     * 获取登录用户下的所有菜单权限
     *
     * @return
     */
    List<SysPermissionVo> listLoginUserMenuPermission();

    /**
     * 根据用户ID获取用户下的所有菜单权限
     *
     * @return
     */
    List<SysPermissionVo> listMenuPermissionByUserId(String userId);

    /**
     * 获取app下的所有权限
     *
     * @param appCode
     * @return
     */
    List<SysPermissionVo> listPermission(@RequestParam("appCode") String appCode);

    /**
     * 权限树
     *
     * @return
     */
    List<SysPermissionVo> listPermissionTree();

    /**
     * 权限树
     *
     * @return
     */
    List<SysPermissionVo> listPermissionTree(String userId);
}
