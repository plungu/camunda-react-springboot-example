package com.camunda.poc.starter.usecase.order.bpm.listener;

import com.camunda.poc.starter.email.EmailService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("email")
@Component("emailApprover")
public class EmailApproverExecutionListener implements ExecutionListener {

    private EmailService emailService;

    @Autowired
    public EmailApproverExecutionListener(EmailService emailService){
        this.emailService = emailService;
    }

    @Override
    public void notify(DelegateExecution execution) throws Exception {


        String country = (String) execution.getVariable("country");
        // get approver for this country from database (hard code for now...)
        String approverEmail = "chris.allen@camunda.com";
        String autoApproveURL = "http://localhost:8080/completeOrderReviewTask?businessKey=" + execution.getBusinessKey() + "&approved=true";
        String autoDeclineURL = "http://localhost:8080/completeOrderReviewTask?businessKey=" + execution.getBusinessKey() + "&approved=false";
        String body = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>\n" +
                "    You are being asked to approve the order of new Promotional Materials for 'some country'.    \n" +
                "</p>\n" +
                "<p>\n" +
                "    You can go into Tasklist to see this task <a href=\"http://localhost:8080/camunda/app/tasklist/default/\">here</a>.  \n" +
                "</p>\n" +
                "    As an alternative, you can click the links below to auto approve/decline this request without going into Tasklist.\n" +
                "<ul>\n" +
                "    <li>Select here to <a target=\"_blank\" href=\"" + autoApproveURL + "\">approve</a>.</li>\n" +
                "    <li>Select here to <a  target=\"_blank\" href=\"" + autoDeclineURL + "\">reject</a>.</li>\n" +
                "</ul>\n" +
                "</body>\n" +
                "</html>";
        String subject = "Your approval is required for PM materials request";
        emailService.sendSimpleMessage(approverEmail, subject, body);
    }
}
