package com.github.fanzezhen.base.logbiz.facade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.fanzezhen.common.core.model.dto.PageDto;
import com.github.fanzezhen.base.logbiz.foundation.entity.LogLogin;
import com.github.fanzezhen.base.logbiz.model.dto.LogLoginDto;
import com.github.fanzezhen.base.logbiz.model.vo.LogLoginVo;

/**
 * @author zezhen.fan
 */
public interface LogLoginServiceFacade {
    boolean add(LogLoginDto logLoginDto);
    IPage<LogLoginVo> page(PageDto<LogLoginDto, LogLogin> pageDto);
}
