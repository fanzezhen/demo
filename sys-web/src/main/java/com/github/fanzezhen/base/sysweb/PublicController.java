package com.github.fanzezhen.base.sysweb;

import com.github.fanzezhen.base.sysbiz.facade.SysPermissionServiceFacade;
import com.github.fanzezhen.base.sysbiz.facade.SysUserServiceFacade;
import com.github.fanzezhen.base.sysbiz.model.vo.SysPermissionVo;
import com.github.fanzezhen.base.sysbiz.model.vo.SysUserVo;
import com.github.fanzezhen.common.core.model.response.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/user/by/username")
    public R<SysUserVo> loadUserByUsername(@RequestParam("username") String username, @RequestParam("appCode") String appCode) {
        return R.ok(sysUserServiceFacade.getByUserName(username, appCode));
    }

    @GetMapping("/permission/list")
    public R<List<SysPermissionVo>> listPermission(@RequestParam("appCode") String appCode) {
        return R.ok(sysPermissionServiceFacade.listAllPermission(appCode));
    }
}
