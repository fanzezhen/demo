package com.github.fanzezhen.demo.logweb.controller;


import com.github.fanzezhen.demo.logbiz.facade.LogExceptionServiceFacade;
import com.github.fanzezhen.common.log.model.dto.ExceptionLogDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.Resource;

/**
 * <p>
 * 异常日志表 前端控制器
 * </p>
 *
 * @author fanzezhen
 * @since 2020-06-11
 */
@Controller
@RequestMapping("/log/exception")
public class LogExceptionController {
    @Resource
    private LogExceptionServiceFacade logExceptionServiceFacade;

    @ResponseBody
    @PostMapping("/add")
    public boolean add(ExceptionLogDto logExceptionDto) {
        return logExceptionServiceFacade.add(logExceptionDto);
    }

}
