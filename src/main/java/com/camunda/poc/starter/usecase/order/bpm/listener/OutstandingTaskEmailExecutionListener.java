package com.camunda.poc.starter.usecase.order.bpm.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

/**
 * This is a Start Event Execution Listener.
 * It prepares email values for a task in the Notification process.
 */
@Component("OutstandingTaskEmailExecutionListener")
public class OutstandingTaskEmailExecutionListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {

        // hardcode test
        execution.setVariable("emailTo", "chris.allen@camunda.com");
        execution.setVariable("emailSubject", "Outstanding Order Task");
        execution.setVariable("emailBody", "This is a reminder that you have PM order tasks available to you.");
        execution.setVariable("emailFrom", "info@foo.com");
        execution.setVariable("emailBcc", "chris.allen@camunda.com");

    }
}
