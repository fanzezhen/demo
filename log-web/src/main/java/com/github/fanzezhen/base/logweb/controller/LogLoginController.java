package com.github.fanzezhen.base.logweb.controller;


import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.github.fanzezhen.common.core.model.dto.PageDto;
import com.github.fanzezhen.base.logbiz.facade.LogLoginServiceFacade;
import com.github.fanzezhen.base.logbiz.foundation.entity.LogLogin;
import com.github.fanzezhen.base.logbiz.model.dto.LogLoginDto;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 登录日志表 前端控制器
 * </p>
 *
 * @author fanzezhen
 * @since 2020-06-11
 */
@Api("登录日志")
@Controller
@RequestMapping("/log/login")
public class LogLoginController {
    @Resource
    private LogLoginServiceFacade logLoginServiceFacade;

    @ResponseBody
    @PostMapping("/record")
    public ResponseData record(LogLoginDto logLoginDto) {
        return ResponseData.success(logLoginServiceFacade.add(logLoginDto));
    }

    @GetMapping("/page")
    public String page(ModelMap modelMap) {
        return "log_login";
    }

    @ResponseBody
    @PostMapping("/page")
    public ResponseData page(@RequestBody PageDto<LogLoginDto, LogLogin> page) {
        return ResponseData.success(logLoginServiceFacade.page(page));
    }

}
