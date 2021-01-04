package com.github.fanzezhen.base.logweb.controller;


import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.github.fanzezhen.base.logbiz.facade.LogOperateFacade;
import com.github.fanzezhen.base.logbiz.facade.LogOperationServiceFacade;
import com.github.fanzezhen.base.logbiz.foundation.entity.LogOperate;
import com.github.fanzezhen.base.logbiz.foundation.entity.LogOperateDetail;
import com.github.fanzezhen.base.logbiz.model.dto.LogOperationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * <p>
 * 操作日志表 前端控制器
 * </p>
 *
 * @author fanzezhen
 * @since 2020-06-11
 */
@Controller
@RequestMapping("/log/operate")
public class LogOperateController {
    @Resource
    private LogOperateFacade logOperateFacade;

    @ResponseBody
    @PostMapping("/add/operate")
    public ResponseData add(@RequestBody LogOperate logOperate) {
        return ResponseData.success(logOperateFacade.addLogOperate(logOperate));
    }

    @ResponseBody
    @PostMapping("/add/operate-detail/batch")
    public ResponseData add(@RequestBody Collection<LogOperateDetail> logOperateDetails) {
        return ResponseData.success(logOperateFacade.addLogOperateDetailBatch(logOperateDetails));
    }
}
