package com.liam.activiti.study.config;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @ProjectName ActivityStudy
 * @PackageName com.liam.activiti.study.practice
 * @ClassName
 * @Description
 * @Author LiangJinTang
 * @Date 2020/7/28 10:52
 **/
public class InitPractice {
    @Test
    public  void initOne() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/activitiDB?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        processEngineConfiguration.setDataSource(driverManagerDataSource);
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
    }

    @Test
    public  void initTwo() {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("/activiti.cfg1.xml");
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
    }

    @Test
    public  void initThree() {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
    }
}
