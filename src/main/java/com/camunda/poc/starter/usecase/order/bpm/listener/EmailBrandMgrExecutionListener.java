package com.camunda.poc.starter.usecase.order.bpm.listener;

import com.camunda.poc.starter.entity.Employee;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

@Component("emailBranchMgr")
public class EmailBrandMgrExecutionListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {

        Employee contact = (Employee) execution.getVariable("employee");
        if(contact != null){
            if(!contact.getEmail().contains("@")){
                throw new BpmnError("217");
            }
        }

        String autoApproveURL = "http://localhost:8080/completeBMApproval?bk=" + execution.getBusinessKey() + "&approved=true";
        String autoDeclineURL = "http://localhost:8080/completeBMApproval?bk=" + execution.getBusinessKey() + "&approved=false";

        String body = "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>\n" +
                "There is an inventory shortfall for promotional items.\n" +
                "</p>\n" +
                "<p>\n" +
                "Therefore, as a Branch Manager, a task has been created for you in Tasklist to approve replenishment.\n" +
                "</p>\n" +
                "<p>\n" +
                "<a  target=\"_blank\" href=\"http://localhost:8080/camunda/app/tasklist/default/\">Click here to go straight to Tasklist to complete your task.</a>\n" +
                "</p>\n" +
                "<p>\n" +
                "If you would prefer to automatically approve or deny, select the following link that is applicable.\n" +
                "<ul>\n" +
                "<li><a target=\"_blank\" href=\"" + autoApproveURL + "\">Approve</a></li>\n" +
                "<li><a target=\"_blank\" href=\"" + autoDeclineURL + "\">Reject</a></li>\n" +
                "</ul>\n" +
                "</p>\n" +
                "</body>\n" +
                "</html>";
        execution.setVariable("emailTo", "branchmgr@az.com");
        execution.setVariable("emailSubject", "Replenish PM Items");
        execution.setVariable("emailBody", body);
        execution.setVariable("emailFrom", "info@workflow.com");
        execution.setVariable("emailBcc", "chris.allen@camunda.com");
    }
}
