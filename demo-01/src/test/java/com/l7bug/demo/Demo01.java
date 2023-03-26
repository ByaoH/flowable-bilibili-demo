package com.l7bug.demo;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.junit.Test;

public class Demo01 {
    /**
     * 获取流程引擎对象
     */
    @Test
    public void testProcessEngine(){
        // ProcessEngineConfiguration 对象
        ProcessEngineConfiguration configuration =new StandaloneProcessEngineConfiguration();
        configuration.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("123456");
        configuration.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/flowable-bilibili-demo?characterEncoding=UTF-8&serverTimezone=GMT%2B8");
        // 设置表结构为更新操作 默认是 false
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 构建 ProcessEngine 对象
        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.err.println(processEngine);
    }
}
