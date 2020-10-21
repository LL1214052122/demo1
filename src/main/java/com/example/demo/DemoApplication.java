package com.example.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }


    @Test
    public void test() {
        // 引擎配置
        ProcessEngineConfiguration pec = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        pec.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        pec.setJdbcUrl("jdbc:mysql://localhost:3306/helloword?createDatabaseIfNotExist=true&serverTimezone=UTC");
        pec.setJdbcUsername("root");
        pec.setJdbcPassword("root");

    /**
     * false 不能自动创建表
     * create-drop 先删除表再创建表
     * true 自动创建和更新表
     */
        pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

    // 获取流程引擎对象
        ProcessEngine processEngine=pec.buildProcessEngine();
        processEngine.getName();

    }
}
