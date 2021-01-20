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

import java.util.List;

@Profile("ordering")
@Component("emailContentProvider")
public class EmailContentProvider implements JavaDelegate {

    private StockItemRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailContentProvider.class);

    @Autowired
    public EmailContentProvider(StockItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        boolean isTest = (Boolean) execution.getVariable("test");
        if (!isTest) {
            List<StockItem> items = repository.findStockItemByQuantityIsLessThan(10);
            for (StockItem item : items) {
                item.setQuantity(50);
            }
            repository.saveAll(items);
        }
    }
}
