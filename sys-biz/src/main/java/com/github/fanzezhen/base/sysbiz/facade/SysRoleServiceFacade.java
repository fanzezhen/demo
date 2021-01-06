package com.github.fanzezhen.base.sysbiz.facade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.fanzezhen.base.sysbiz.foundation.entity.SysRole;
import com.github.fanzezhen.base.sysbiz.model.dto.SysRoleDto;
import com.github.fanzezhen.base.sysbiz.model.vo.SysRoleVo;
import com.github.fanzezhen.common.core.model.dto.PageDto;

import java.util.List;

/**
 * @author zezhen.fan
 */
public interface SysRoleServiceFacade {
    /**
     * 查
     *
     * @param id 主键
     * @return 角色
     */
    SysRoleVo getById(String id);

    /**
     * 查
     *
     * @return 角色列表
     */
    List<SysRoleVo> list();

    /**
     * 查询所有有效的角色
     *
     * @return 角色列表
     */
    List<SysRoleVo> listValid();

    /**
     * 查询角色ID列表
     *
     * @param userId 用户ID
     * @return 角色ID列表
     */
    List<Object> listIdObjByUserId(String userId);

    /**
     * 查询列表
     *
     * @param userId 用户ID
     * @return 角色列表
     */
    List<SysRoleVo> listByUserId(String userId);

    /**
     * 分页查询
     *
     * @param pageDto 分页参数及其他查询条件封装
     * @return 分页结果
     */
    IPage<SysRoleVo> page(PageDto<SysRoleDto, SysRole> pageDto);
}
