package com.l7bug.api;

import org.flowable.engine.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Demo01
 *
 * @author luliangyu
 * @since 2023-04-21 10:29
 */
public class Demo01 {
	private ProcessEngineConfiguration processEngineConfiguration;

	private ProcessEngine processEngine;

	@Before
	public void before() {
		this.processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
		this.processEngine = processEngineConfiguration.buildProcessEngine();
	}

	@Test
	public void getServicesTest() {
		RepositoryService repositoryService = processEngine.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		TaskService taskService = processEngine.getTaskService();
		IdentityService identityService = processEngine.getIdentityService();
		FormService formService = processEngine.getFormService();
		HistoryService historyService = processEngine.getHistoryService();
		ManagementService managementService = processEngine.getManagementService();
		DynamicBpmnService dynamicBpmnService = processEngine.getDynamicBpmnService();
		System.err.println();
	}
}
