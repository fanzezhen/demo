package com.github.fanzezhen.demo.logweb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.fanzezhen.common.mp.model.dto.PageDto;
import com.github.fanzezhen.demo.logbiz.facade.LogLoginServiceFacade;
import com.github.fanzezhen.common.log.foundation.entity.LogLogin;
import com.github.fanzezhen.common.log.model.dto.LogLoginDto;
import com.github.fanzezhen.common.log.model.vo.LogLoginVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * <p>
 * 登录日志表 前端控制器
 * </p>
 *
 * @author fanzezhen
 * @since 2020-06-11
 */
@Tag(name = "登录日志")
@Controller
@RequestMapping("/log/login")
public class LogLoginController {
    @Resource
    private LogLoginServiceFacade logLoginServiceFacade;

    @ResponseBody
    @PostMapping("/add")
    public boolean add(LogLoginDto logLoginDto) {
        return logLoginServiceFacade.add(logLoginDto);
    }

    @GetMapping("/page")
    public String page() {
        return "log_login";
    }

    @ResponseBody
    @PostMapping("/page")
    public IPage<LogLoginVo> page(@RequestBody PageDto<LogLoginDto, LogLogin> page) {
        return logLoginServiceFacade.page(page);
    }

}
