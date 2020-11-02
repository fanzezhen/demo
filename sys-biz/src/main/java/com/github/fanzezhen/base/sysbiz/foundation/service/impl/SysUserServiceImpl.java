package com.github.fanzezhen.base.sysbiz.foundation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.fanzezhen.base.sysbiz.foundation.entity.SysUser;
import com.github.fanzezhen.base.sysbiz.foundation.mapper.SysUserMapper;
import com.github.fanzezhen.base.sysbiz.foundation.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author fanzezhen
 * @since 2020-05-08
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
