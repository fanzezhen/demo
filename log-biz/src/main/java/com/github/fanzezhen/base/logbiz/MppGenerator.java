package com.github.fanzezhen.base.logbiz;

import com.github.fanzezhen.common.core.generator.GeneratorTool;
import com.github.fanzezhen.common.core.generator.MysqlGenerator;

/**
 * @author zezhen.fan
 */
public class MppGenerator {
    public static void main(String[] args) {
        String dataSourceConfigUrl = "jdbc:mysql://localhost:3306/base?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String dbUsername = "root";
        String dbPassword = "root";
        String moduleParentName = "com.github.fanzezhen.base.logbiz";
        GeneratorTool.generator(MysqlGenerator.builder().build()
                .setAuthor("fanzezhen")
                .setDataSourceConfigUrl(dataSourceConfigUrl)
                .setDbUsername(dbUsername)
                .setDbPassword(dbPassword)
                .setSuperiorModuleNames("log-biz")
                .setParentPackageName(moduleParentName)
                .setSuperEntityClass(com.github.fanzezhen.common.core.model.entity.BaseVarEntity.class));
    }
}
