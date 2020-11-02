package com.github.fanzezhen.base.logweb;


import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.github.fanzezhen.base.logbiz.facade.LogOperationServiceFacade;
import com.github.fanzezhen.base.logbiz.model.dto.LogOperationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
    private LogOperationServiceFacade logOperationServiceFacade;

    @ResponseBody
    @PostMapping("/record")
    public ResponseData record(LogOperationDto logOperationDto) {
        return ResponseData.success(logOperationServiceFacade.add(logOperationDto));
    }
}
