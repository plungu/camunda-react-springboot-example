package com.camunda.poc.starter.usecase.order.bpm.delegate;

import com.camunda.poc.starter.usecase.order.entity.StockItem;
import com.camunda.poc.starter.usecase.order.repo.StockItemRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

@Profile("ordering")
@Component("getItemInventory")
public class GetItemInventory implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetItemInventory.class);

    private StockItemRepository repository;

    @Autowired
    public GetItemInventory(StockItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        boolean shortfall = false;
        List<Map<String, Object>> shortfallList = new ArrayList<>();
        boolean error = (Boolean) execution.getVariable("error");
        if(error == true){
            throw new Exception("Inventory Service is down!");
        }
        List<StockItem> list = repository.findStockItemByQuantityIsLessThan(10);
        if (!list.isEmpty()){
            shortfall = true;
            for (StockItem item: list){
                Map<String, Object> map = new HashMap<>();
                map.put("PmiCode", item.getPmiCode());
                map.put("PmiDescription", item.getPmiDescription());
                map.put("Quantity", item.getQuantity());
                map.put("Id", item.getId());
                shortfallList.add(map);
            }
        }
        execution.setVariable("shortfall", shortfall);
        execution.setVariable("shortfallList", shortfallList);
    }
}
