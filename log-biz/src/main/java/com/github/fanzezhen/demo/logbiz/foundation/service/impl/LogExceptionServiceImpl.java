package com.github.fanzezhen.demo.logbiz.foundation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.fanzezhen.demo.logbiz.foundation.entity.LogException;
import com.github.fanzezhen.demo.logbiz.foundation.mapper.LogExceptionMapper;
import com.github.fanzezhen.demo.logbiz.foundation.service.ILogExceptionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 异常日志表 服务实现类
 * </p>
 *
 * @author fanzezhen
 * @since 2021-04-28
 */
@Service
public class LogExceptionServiceImpl extends ServiceImpl<LogExceptionMapper, LogException> implements ILogExceptionService {

}
