package com.camunda.poc.starter.boa;

import com.camunda.poc.starter.bpm.LoggerDelegate;
import org.apache.ibatis.logging.LogFactory;

import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;

import org.junit.Rule;
import org.junit.Test;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */
public class HappyPathProcessTest {

  private static final String PROCESS_DEFINITION_KEY = "recruiter-workflow";
  static {
    LogFactory.useSlf4jLogging(); // MyBatis
  }

  @Rule
  public final ProcessEngineRule processEngine = TestCoverageProcessEngineRuleBuilder.create().build();

  @Deployment(resources = {"processes/recruiter-workflow.bpmn", "processes/hiring-decision.dmn"})

  @Test
  public void testHappyPath() {

      //Mock Delegates used in the process
      Mocks.register("logger", new LoggerDelegate());

      // Either: Drive the process by API and assert correct behavior by camunda-bpm-assert, e.g.:
      ProcessInstance processInstance =
              processEngine().getRuntimeService()
                      .startProcessInstanceByKey(PROCESS_DEFINITION_KEY);

      // Now: Drive the process by API and assert correct behavior by camunda-bpm-assert
      assertThat(processInstance).isActive();

      //if a async job is created than we have to be sure we are waiting at the right place and execute the job
      //assertThat(processInstance).isWaitingAt("sendInitalTenantMessage");
      //execute(job());

      // check we are waiting at the correct activity and than correlate message
      //assertThat(processInstance).isWaitingAt("awaitTenantReply");
      //processEngine().getRuntimeService().correlateMessage("tenant_reply_message");

      assertThat(processInstance).isWaitingAt("enter-offer-details");
      complete(task(), withVariables("approved", true));

      assertThat(processInstance).isWaitingAt("legal-checks");
      complete(task(), withVariables("approved", true));

      assertThat(processInstance).isEnded();

  }

}
