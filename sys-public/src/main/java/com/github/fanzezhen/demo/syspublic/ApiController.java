package com.github.fanzezhen.demo.syspublic;

import com.github.fanzezhen.demo.sysbiz.facade.SysPermissionServiceFacade;
import com.github.fanzezhen.demo.sysbiz.facade.SysUserServiceFacade;
import com.github.fanzezhen.demo.sysbiz.model.vo.SysPermissionVo;
import com.github.fanzezhen.demo.sysbiz.model.vo.SysUserVo;
import com.github.fanzezhen.common.core.model.response.ActionResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * @author zezhen.fan
 */
@RestController
public class ApiController {
    @Resource
    private SysUserServiceFacade sysUserServiceFacade;
    @Resource
    private SysPermissionServiceFacade sysPermissionServiceFacade;

    @GetMapping(value = "/user/by/username", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActionResult<SysUserVo> loadUserByUsername(@RequestParam("username") String username,
                                                      @RequestParam("appCode") String appCode) {
        return ActionResult.success(sysUserServiceFacade.getByUserName(username, appCode));
    }

    @GetMapping(value = "/permission/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActionResult<List<SysPermissionVo>> listPermission(@RequestParam("appCode") String appCode) {
        return ActionResult.success(sysPermissionServiceFacade.listAllPermission(appCode));
    }
}
