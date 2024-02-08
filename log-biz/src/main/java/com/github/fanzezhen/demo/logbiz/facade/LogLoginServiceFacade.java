package com.github.fanzezhen.demo.logbiz.facade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.fanzezhen.common.mp.model.dto.PageDto;
import com.github.fanzezhen.demo.logbiz.foundation.entity.LogLogin;
import com.github.fanzezhen.demo.logbiz.model.dto.LogLoginDto;
import com.github.fanzezhen.demo.logbiz.model.vo.LogLoginVo;

/**
 * @author zezhen.fan
 */
public interface LogLoginServiceFacade {
    /**
     * 增
     *
     * @param logLoginDto 封装
     * @return 布尔
     */
    boolean add(LogLoginDto logLoginDto);

    /**
     * 查
     *
     * @param pageDto 分页参数及其他查询条件封装
     * @return 分页内容
     */
    IPage<LogLoginVo> page(PageDto<LogLoginDto, LogLogin> pageDto);
}
