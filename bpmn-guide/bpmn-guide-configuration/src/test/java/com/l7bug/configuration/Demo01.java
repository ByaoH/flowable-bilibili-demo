package com.l7bug.configuration;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.junit.Before;
import org.junit.Test;

/**
 * Demo01
 *
 * @author luliangyu
 * @since 2023-04-11 18:17
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
	public void getProcessEngineTest() {
		System.err.println("processEngine = " + processEngine);
	}
}
