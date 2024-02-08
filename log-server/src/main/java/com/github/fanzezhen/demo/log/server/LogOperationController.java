package com.github.fanzezhen.demo.log.server;

import com.github.fanzezhen.demo.logbiz.facade.LogOperationFacade;
import com.github.fanzezhen.demo.logbiz.model.dto.LogOperationDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RestController
@Tag(name = "测试Controller", description = "这是描述")
@RequestMapping("/log/operation")
public class LogOperationController {
    @Resource
    private LogOperationFacade logOperationFacade;

    @PostMapping("/add")
    public boolean add(@RequestBody LogOperationDto logOperationDto) {
        return logOperationFacade.addLogOperate(logOperationDto);
    }

    @ApiResponse(responseCode = "2", description = "动物园实体对象")

    @GetMapping("/test")
    public boolean test(@RequestParam(required = false, defaultValue = "ii") String id
//            , @RequestBody LogOperationDto logOperationDto
    ) {
        return true;
    }
}
