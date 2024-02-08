package com.github.fanzezhen.demo.sysbiz.remote;

import com.github.fanzezhen.common.core.model.response.ActionResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zezhen.fan
 */
@FeignClient(name = "demo-log-server")
public interface LogRemote {

    /**
     * 测试
     *
     * @return 测试
     */
    @PostMapping("/log/operation/test")
    ActionResult<Object> testOperationLog();

}
