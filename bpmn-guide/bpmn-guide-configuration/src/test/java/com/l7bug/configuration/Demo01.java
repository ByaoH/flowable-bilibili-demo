package com.l7bug.configuration;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * Demo01
 *
 * @author luliangyu
 * @since 2023-04-11 18:17
 */
public class Demo01 {
	@Test
	public void getProcessEngineTest() {
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
		ProcessEngine processEngine = configuration.buildProcessEngine();
		System.err.println("processEngine = " + processEngine);
	}
}
