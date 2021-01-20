package com.camunda.poc.starter.usecase.order.bpm.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Profile("ordering")
@Component("InitNotificationVars")
public class InitNotificationVars implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        Random rand = new Random();
        int maxNumOfCodes = 5;
        // number btwn 0 and 4
        int numOfCodes = rand.nextInt(maxNumOfCodes);
        // number btwn 1 and 5
        numOfCodes++;
        String[] codeArray = {"GB", "US", "AU", "CA", "DE", "FR", "ROW"};
        List<String> codeList = new ArrayList<>();
        for (int i = 1; i <= numOfCodes; i++){
            // 0-6
            int index = rand.nextInt(7);
            codeList.add(codeArray[index]);
        }

//        execution.setVariable("eligible", true);
//        execution.setVariable("openTasks", true);
        execution.setVariable("promoCodes", codeList);

    }
}
