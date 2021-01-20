package com.camunda.poc.starter.usecase.order.bpm.delegate;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Profile("ordering")
@Component("CreateOrderTasksDelegate")
public class CreateOrderTasksDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        RuntimeService runtimeService = execution.getProcessEngine().getRuntimeService();
        Map<String, Object> varMap = new HashMap<>();
        Map<String, Object> resultMap = (Map<String, Object>) execution.getVariable("resultMap");
        varMap.put("country", (String) resultMap.get("country"));
        varMap.put("promoCode", (String) execution.getVariable("promoCode"));
        varMap.put("assignee", "demo");
        runtimeService.correlateMessage(
                "CreateOrderTasksStartMsg", "bk-" + System.currentTimeMillis(), varMap);
    }
}
