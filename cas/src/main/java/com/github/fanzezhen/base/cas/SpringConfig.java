package com.github.fanzezhen.base.cas;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zezhen.fan
 */
@Configuration
@ComponentScan("com.github.fanzezhen.base.cas")
@Import(cn.hutool.extra.spring.SpringUtil.class)
public class SpringConfig {
}
