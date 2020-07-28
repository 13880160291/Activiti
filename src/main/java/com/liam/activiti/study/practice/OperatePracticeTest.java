package com.liam.activiti.study.practice;

import com.alibaba.fastjson.JSON;
import com.liam.activiti.study.utils.ValidationUtils;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @ProjectName ActivityStudy
 * @PackageName com.liam.activiti.study.practice
 * @ClassName
 * @Description
 * @Author LiangJinTang
 * @Date 2020/7/28 14:00
 **/
public class OperatePracticeTest {

    private static final Logger logger = LoggerFactory.getLogger(OperatePracticeTest.class);

    private ProcessEngine processEngine;


    @Before
    public  void initVar(){
        processEngine= ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault().buildProcessEngine();
    }

    @Test
    public void deployProcess() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment().name("审批流程")
                .addClasspathResource("bpmn/FirstDemo.bpmn")
                .addClasspathResource("bpmn/FirstDemo.png")
                .deploy();
        logger.info("ActivitiOperateServiceImpl|deployProcess|result={}", JSON.toJSONString(deploy));
    }
    @Test
    public void startProcess() {
        String processDefineId="FirstDemo:1:4";
        ProcessInstance processInstance = null;
        processInstance=processEngine.getRuntimeService().startProcessInstanceById(processDefineId);
    }
    @Test
    public void findTask() {
        String assignee="";
        List<Task> taskList = processEngine.getTaskService().createTaskQuery().taskAssignee(assignee).desc().list();
        logger.info("ActivitiOperateServiceImpl|findTask|result={}", taskList);
    }
    @Test
    public void dealWithTask() {
        String taskId="";
        processEngine.getTaskService().complete(taskId);
    }


}
