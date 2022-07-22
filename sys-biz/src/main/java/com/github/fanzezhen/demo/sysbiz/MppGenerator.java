package com.github.fanzezhen.demo.sysbiz;

import com.github.fanzezhen.common.mp.generator.GeneratorTool;
import com.github.fanzezhen.common.mp.generator.MysqlGenerator;

/**
 * @author zezhen.fan
 */
public class MppGenerator {
    public static void main(String[] args) {
        String dataSourceConfigUrl = "jdbc:mysql://localhost:3306/edc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String dbUsername = "root";
        String dbPassword = "root";
        String moduleParentName = "com.github.fanzezhen.common.mp.generator";
        GeneratorTool.generator(MysqlGenerator.builder().build()
                .setAuthor("fanzezhen")
                .setDataSourceConfigUrl(dataSourceConfigUrl)
                .setDbUsername(dbUsername)
                .setDbPassword(dbPassword)
                .setSuperiorModuleNames("log-biz")
                .setParentPackageName(moduleParentName)
                .setSuperEntityClass(com.github.fanzezhen.common.mp.model.entity.BaseVarEntity.class));
    }
}
