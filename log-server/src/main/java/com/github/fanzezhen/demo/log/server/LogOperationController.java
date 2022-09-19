package com.github.fanzezhen.demo.log.server;


import com.github.fanzezhen.common.log.model.dto.LogOperationDto;
import com.github.fanzezhen.demo.logbiz.facade.LogOperationFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 * 操作日志表 前端控制器
 * </p>
 *
 * @author fanzezhen
 * @since 2020-06-11
 */
@Controller
@RequestMapping("/log/operation")
public class LogOperationController {
    @Resource
    private LogOperationFacade logOperationFacade;

    @ResponseBody
    @PostMapping("/add")
    public boolean add(@RequestBody LogOperationDto logOperationDto) {
        return logOperationFacade.addLogOperate(logOperationDto);
    }

    @ResponseBody
    @PostMapping("/test")
    public boolean record() {
        return true;
    }
}
