package com.l7bug.demo;

import org.flowable.engine.*;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {
    private static ProcessEngineConfiguration getProcessEngineConfiguration() {
        ProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();
        configuration.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("123456");
        configuration.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/flowable-bilibili-demo?characterEncoding=UTF-8&serverTimezone=GMT%2B8");
        // 设置表结构为更新操作 默认是 false
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        return configuration;
    }

    /**
     * 获取流程引擎对象
     */
    @Test
    public void testProcessEngine() {
        // ProcessEngineConfiguration 对象
        ProcessEngineConfiguration configuration = getProcessEngineConfiguration();
        // 构建 ProcessEngine 对象
        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.err.println(processEngine);
    }

    /**
     * 发布流程
     */
    @Test
    public void deploy() {
        ProcessEngine processEngine = getProcessEngineConfiguration().buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("holiday-request.bpmn20.xml")
                .deploy();
    }

    /**
     * 查找流程
     */
    @Test
    public void queryDeployment() {
        ProcessEngine processEngine = getProcessEngineConfiguration().buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        System.err.println("list.size() = " + list.size());
        for (ProcessDefinition processDefinition : list) {
            System.err.println("Found process definition : " + processDefinition.getName());
            System.err.println(processDefinition.getKey());
            System.err.println("####################");
        }
    }

    /**
     * 启动流程
     */
    @Test
    public void startProcess() {
        System.out.println("Who are you?");
        String employee = "SB";
        System.out.println("employee = " + employee);

        System.out.println("How many holidays do you want to request?");
        int nrOfHolidays = 10;
        System.out.println("nrOfHolidays = " + nrOfHolidays);

        System.out.println("Why do you need them?");
        String description = "我就是想请假";
        System.out.println("description = " + description);

        ProcessEngine processEngine = getProcessEngineConfiguration().buildProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> variables = new HashMap<>(3);
        variables.put("employee", employee);
        variables.put("nrOfHolidays", nrOfHolidays);
        variables.put("description", description);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holidayRequest", variables);
        System.err.println(processInstance);
    }

    @Test
    public void deleteProcessInstance() {
        ProcessEngine processEngine = getProcessEngineConfiguration().buildProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        List<ProcessInstance> processInstanceList = runtimeService.createProcessInstanceQuery().list();
        System.out.println("processInstanceList.size() = " + processInstanceList.size());
        for (ProcessInstance processInstance : processInstanceList) {
            System.err.println(processInstance);
            // runtimeService.deleteProcessInstance(processInstance.getId(), "");
        }
    }

    @Test
    public void queryTask() {
        ProcessEngine processEngine = getProcessEngineConfiguration().buildProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        List<Task> list = taskService.createTaskQuery().list();
        int step = 0;
        for (Task task : list) {
            System.err.println(task);
            Map<String, Object> variables = taskService.getVariables(task.getId());
            System.err.println(variables);
            // boolean approved = step % 2 == 0;
            boolean approved = false;
            System.err.println(approved);
            taskService.complete(task.getId(), Map.of("approved", approved));
            step++;
        }
    }
}
