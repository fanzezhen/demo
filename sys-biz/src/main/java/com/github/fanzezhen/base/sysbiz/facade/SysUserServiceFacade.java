package com.github.fanzezhen.base.sysbiz.facade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.fanzezhen.base.sysbiz.foundation.entity.SysUser;
import com.github.fanzezhen.base.sysbiz.model.dto.SysUserDto;
import com.github.fanzezhen.base.sysbiz.model.vo.SysUserVo;
import com.github.fanzezhen.common.core.model.dto.PageDto;

import java.util.List;

/**
 * @author zezhen.fan
 */
public interface SysUserServiceFacade {
    /**
     * 分页查询
     *
     * @param pageDto 分页参数及其他查询条件封装
     * @return 分页结果
     */
    IPage<SysUserVo> page(PageDto<SysUserDto, SysUser> pageDto);

    /**
     * 查
     *
     * @param id 用户ID
     * @return 用户信息
     */
    SysUserVo getById(String id);

    /**
     * 查询
     *
     * @param username 用户名
     * @return 用户信息
     */
    SysUserVo getByUserName(String username);

    /**
     * 查
     *
     * @param username 用户名
     * @param appCode  应用代码
     * @return 用户信息
     */
    SysUserVo getByUserName(String username, String appCode);

    /**
     * 保存
     *
     * @param sysUserDto 用户信息
     * @return 用户信息
     */
    SysUserVo save(SysUserDto sysUserDto);

    /**
     * 保存
     *
     * @param sysUserDtoList 用户信息
     * @return 用户信息
     */
    List<SysUserVo> saveBatch(List<SysUserDto> sysUserDtoList);
}
