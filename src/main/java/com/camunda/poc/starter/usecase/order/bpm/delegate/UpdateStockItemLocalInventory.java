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

@Profile("ordering")
@Component("updatePMItemLocalInventory")
public class UpdateStockItemLocalInventory implements JavaDelegate {

    private StockItemRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateStockItemLocalInventory.class);

    @Autowired
    public UpdateStockItemLocalInventory(StockItemRepository itemrepo) {
        this.repository = itemrepo;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOGGER.info("\n\n  ... "+ UpdateStockItemLocalInventory.class.getSimpleName()+" invoked by "
                + "processDefinitionId=" + execution.getProcessDefinitionId()
                + ", activtyId=" + execution.getCurrentActivityId()
                + ", activtyName='" + execution.getCurrentActivityName() + "'"
                + ", processInstanceId=" + execution.getProcessInstanceId()
                + ", businessKey=" + execution.getProcessBusinessKey()
                + ", executionId=" + execution.getId()
                + " \n\n");

        Iterable<StockItem> items = repository.findAll();

        for (StockItem item: items){
            item.setQuantity(5);
            LOGGER.info("\n PM ITEM: "+item.getId() +"  "+item.toString());
            repository.save(item);
        }

        //TODO: implement save all
    }
}
