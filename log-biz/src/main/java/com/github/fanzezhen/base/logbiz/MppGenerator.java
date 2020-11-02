package com.github.fanzezhen.base.logbiz;

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
        GeneratorTool.generator(new MysqlGenerator(dataSourceConfigUrl, dbUsername, dbPassword, moduleParentName));
    }
}
