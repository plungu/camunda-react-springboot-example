package com.camunda.poc.starter.usecase.order.bpm.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

@Component("emailSalesRepListner")
public class EmailSalesRepOrderApprovedListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {

        String body = "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>\n" +
                "Your order has been approved by your manager.\n" +
                "</p>\n" +
                "<p>\n" +
                "<a  target=\"_blank\" href=\"http://localhost:8080/app.html#/orders\">Click here to see you order status.</a>\n" +
                "</p>\n" +

                "</body>\n" +
                "</html>";

        execution.setVariable("emailTo", "sales-rep@az.com");
        execution.setVariable("emailSubject", "Order Approved");
        execution.setVariable("emailBody", body);
        execution.setVariable("emailFrom", "info@workflow.com");
        execution.setVariable("emailBcc", "paul.lungu@camunda.com");
    }
}
