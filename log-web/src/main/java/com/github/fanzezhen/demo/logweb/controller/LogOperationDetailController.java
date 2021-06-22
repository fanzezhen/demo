package com.github.fanzezhen.demo.logweb.controller;


import com.github.fanzezhen.demo.logbiz.facade.LogOperationFacade;
import com.github.fanzezhen.common.log.foundation.entity.LogOperationDetail;
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
@RequestMapping("/log/operation")
public class LogOperationDetailController {
    @Resource
    private LogOperationFacade logOperationFacade;

    @ResponseBody
    @PostMapping("/add/operate-detail/batch")
    public boolean add(@RequestBody Collection<LogOperationDetail> logOperateDetails) {
        return logOperationFacade.addLogOperateDetailBatch(logOperateDetails);
    }
}
