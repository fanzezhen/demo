package com.github.fanzezhen.base.logbiz.facade.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.fanzezhen.common.core.model.dto.PageDto;
import com.github.fanzezhen.common.core.util.BeanConverterUtil;
import com.github.fanzezhen.base.logbiz.facade.LogLoginServiceFacade;
import com.github.fanzezhen.base.logbiz.foundation.entity.LogLogin;
import com.github.fanzezhen.base.logbiz.foundation.service.ILogLoginService;
import com.github.fanzezhen.base.logbiz.model.dto.LogLoginDto;
import com.github.fanzezhen.base.logbiz.model.vo.LogLoginVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LogLoginServiceFacadeImpl implements LogLoginServiceFacade {
    @Resource
    private ILogLoginService logLoginService;

    @Override
    public boolean add(LogLoginDto logLoginDto) {
        return logLoginService.save(logLoginDto);
    }

    @Override
    public IPage<LogLoginVo> page(PageDto<LogLoginDto, LogLogin> pageDto) {
        return logLoginService.page(pageDto).convert(this::toVo);
    }
    private LogLoginVo toVo(LogLogin logLogin) {
        if (logLogin == null) return null;
        return BeanConverterUtil.copy(logLogin, new LogLoginVo());
    }
}
