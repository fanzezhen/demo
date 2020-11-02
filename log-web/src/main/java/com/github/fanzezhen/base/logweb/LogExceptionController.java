package com.github.fanzezhen.base.logweb;


import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.github.fanzezhen.base.logbiz.facade.LogExceptionServiceFacade;
import com.github.fanzezhen.base.logbiz.model.dto.LogExceptionDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
    private LogExceptionServiceFacade LogExceptionServiceFacade;

    @ResponseBody
    @PostMapping("/record")
    public ResponseData record(LogExceptionDto LogExceptionDto) {
        return ResponseData.success(LogExceptionServiceFacade.add(LogExceptionDto));
    }

}
