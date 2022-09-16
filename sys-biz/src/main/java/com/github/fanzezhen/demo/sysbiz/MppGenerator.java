package com.github.fanzezhen.demo.sysbiz;

import com.github.fanzezhen.common.mp.generator.GeneratorBean;
import com.github.fanzezhen.common.mp.generator.GeneratorTool;

/**
 * @author zezhen.fan
 */
public class MppGenerator {
    public static void main(String[] args) {
        String dataSourceConfigUrl = "jdbc:mysql://localhost:3306/edc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String dbUsername = "root";
        String dbPassword = "root";
        String moduleParentName = "com.github.fanzezhen.common.mp.generator";
        GeneratorTool.generator(new GeneratorBean()
                .setAuthor("fanzezhen")
                .setDbUrl(dataSourceConfigUrl)
                .setDbUsername(dbUsername)
                .setDbPassword(dbPassword)
                .setModuleName("log-biz")
                .setParentPackageName(moduleParentName)
                .setSuperEntityClass(com.github.fanzezhen.common.mp.model.entity.BaseEntity.class));
    }
}
