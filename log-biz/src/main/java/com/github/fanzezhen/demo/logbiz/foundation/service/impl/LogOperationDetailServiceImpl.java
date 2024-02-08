package com.github.fanzezhen.demo.logbiz.foundation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.fanzezhen.demo.logbiz.foundation.entity.LogOperationDetail;
import com.github.fanzezhen.demo.logbiz.foundation.mapper.LogOperationDetailMapper;
import com.github.fanzezhen.demo.logbiz.foundation.service.ILogOperationDetailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志详情表 服务实现类
 * </p>
 *
 * @author fanzezhen
 * @since 2021-04-28
 */
@Service
public class LogOperationDetailServiceImpl extends ServiceImpl<LogOperationDetailMapper, LogOperationDetail> implements ILogOperationDetailService {

}
