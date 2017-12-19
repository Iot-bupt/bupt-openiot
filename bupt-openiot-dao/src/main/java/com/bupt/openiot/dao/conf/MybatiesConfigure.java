package com.bupt.openiot.dao.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dy on 2017/5/4.
 */
@Configuration
@MapperScan(basePackages = "com.bupt.openiot.dao.mapper")
public class MybatiesConfigure {

}
