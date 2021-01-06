package com.github.fanzezhen.base.sysweb;

import com.github.fanzezhen.common.core.util.SysServerInfoUtil;
import com.github.fanzezhen.base.sysbiz.facade.SysPermissionServiceFacade;
import com.github.fanzezhen.common.security.util.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author zezhen.fan
 */
@Controller
public class CommonController extends com.github.fanzezhen.base.sysweb.BaseController {
    @Resource
    private SysPermissionServiceFacade sysPermissionServiceFacade;

    @GetMapping("/")
    public String empty() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String indexView(ModelMap modelMap) {
        modelMap.addAttribute("permissionList", sysPermissionServiceFacade.listMenuPermissionByUserId(SecurityUtil.getLoginUserId()));
        return "index";
    }

    @GetMapping("/welcome/view")
    public String welcomeView(ModelMap modelMap) {
        modelMap.addAttribute("javaVersion", System.getProperty("java.version") + " " + System.getProperty("java.vm.name"));
        modelMap.addAttribute("diskRating", SysServerInfoUtil.getDiskRating());
        return "welcome";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

}
