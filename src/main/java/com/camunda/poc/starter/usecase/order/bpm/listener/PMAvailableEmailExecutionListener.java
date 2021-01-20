package com.camunda.poc.starter.usecase.order.bpm.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * This is a Start Event Execution Listener.
 * It prepares email values for a task in the Notification process.
 */
@Component("PMAvailEmailExecutionListener")
public class PMAvailableEmailExecutionListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {

        Map<String, Object> resultMap = (Map<String, Object>) execution.getVariable("resultMap");
        String emailbody = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>\n" +
                "    Promotional material is now available to the sales team for the '" + resultMap.get("country") + "' region.\n" +
                "</p>\n" +
                "<p>\n" +
                "    <a target=\"_blank\" href=\"http://localhost:8080/app.html\">Click here to order promotional materials</a> \n" +
                "</p>\n" +
                "</body>\n" +
                "</html>";

        // hardcode test
        execution.setVariable("emailTo", "chris.allen@camunda.com");
        execution.setVariable("emailSubject", "Promo Material is now available");
        execution.setVariable("emailBody", emailbody);
        execution.setVariable("emailFrom", "info@foo.com");
        execution.setVariable("emailBcc", "chris.allen@camunda.com");
//        }

    }
}
