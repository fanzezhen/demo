package com.github.fanzezhen.demo.log.server;

import com.github.fanzezhen.common.log.model.dto.LogOperationDto;
import com.github.fanzezhen.demo.logbiz.facade.LogOperationFacade;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * <p>
 * 操作日志表 前端控制器
 * </p>
 *
 * @author fanzezhen
 * @since 2020-06-11
 */
@Controller
@Tag(name = "测试Controller", description = "这是描述")
@RequestMapping("/log/operation")
public class LogOperationController {
    @Resource
    private LogOperationFacade logOperationFacade;

    @ResponseBody
    @PostMapping("/add")
    public boolean add(@RequestBody LogOperationDto logOperationDto) {
        return logOperationFacade.addLogOperate(logOperationDto);
    }

    @ApiResponse(responseCode = "2xx", description = "动物园实体对象")
    @ResponseBody
    @GetMapping("/test")
    public boolean record() {
        return true;
    }
}
