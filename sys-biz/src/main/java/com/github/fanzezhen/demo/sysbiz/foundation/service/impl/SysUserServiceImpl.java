package com.github.fanzezhen.demo.sysbiz.foundation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.fanzezhen.demo.sysbiz.foundation.entity.SysUser;
import com.github.fanzezhen.demo.sysbiz.foundation.mapper.SysUserMapper;
import com.github.fanzezhen.demo.sysbiz.foundation.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author fanzezhen
 * @since 2021-04-28
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
