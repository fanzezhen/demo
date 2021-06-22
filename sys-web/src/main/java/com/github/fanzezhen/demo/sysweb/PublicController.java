package com.github.fanzezhen.demo.sysweb;

import com.github.fanzezhen.demo.sysbiz.facade.SysPermissionServiceFacade;
import com.github.fanzezhen.demo.sysbiz.facade.SysUserServiceFacade;
import com.github.fanzezhen.demo.sysbiz.model.vo.SysPermissionVo;
import com.github.fanzezhen.demo.sysbiz.model.vo.SysUserVo;
import com.github.fanzezhen.common.core.model.response.ActionResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zezhen.fan
 */
@RestController
@RequestMapping("/public")
public class PublicController {
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
