package com.github.fanzezhen.demo.cas.controller;

import org.apereo.cas.authentication.principal.Service;
import org.apereo.cas.services.RegexRegisteredService;
import org.apereo.cas.services.ReturnAllAttributeReleasePolicy;
import org.apereo.cas.services.ServicesManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author anumbrella
 */
@RestController
@RequestMapping("/services")
public class ServicesManagerController {
    @Resource
    @Qualifier("servicesManager")
    private ServicesManager servicesManager;

    /**
     * 添加cas客户端
     * 增加了单点退出功能，cas退出默认使用隐式退出
     * protocol 代表的是协议，比如: http或者https的协议
     */
    @RequestMapping(value = "/addClient/{protocol}/{serviceId}/{id}", method = RequestMethod.GET)
    public String addService(@PathVariable("serviceId") String serviceId,
                             @PathVariable("protocol") String protocol,
                             @PathVariable("id") int id) throws IOException {
        String url = protocol + "://" + serviceId;
        // serviceId,可以配置为正则匹配
        String a = "^" + url + ".*";
        RegexRegisteredService service = new RegexRegisteredService();
        ReturnAllAttributeReleasePolicy re = new ReturnAllAttributeReleasePolicy();
        service.setServiceId(a);
        service.setId(id);
        service.setAttributeReleasePolicy(re);
        //将name统一设置为servicesId
        service.setName(serviceId);
        //单点登出
        service.setLogoutUrl(url);
        servicesManager.save(service, true);
        servicesManager.load();
        return "1";
    }

    /**
     * 删除服务
     *
     * @param serviceId ^(http|https|imaps)://.*
     * @return success/failed
     */
    @RequestMapping(value = "/delete/{serviceId}", method = RequestMethod.GET)
    public String delService(@PathVariable("serviceId") String serviceId) {
        String res = "";
        RegexRegisteredService service = new RegexRegisteredService();
        service.setServiceId(serviceId);
        try {
            servicesManager.delete(service);
        } catch (Exception e) {
            if (null == servicesManager.findServiceBy(new Service() {
                @Override
                public void setAttributes(Map<String, List<Object>> attributes) {
                }

                @Override
                public String getId() {
                    return serviceId;
                }
            })) {
                res = "success";
                servicesManager.load();
            } else {
                res = "failed";
            }
        }
        return res;
    }
}