package com.camunda.poc.starter.usecase.order.repo;

import com.camunda.poc.starter.usecase.order.entity.OrderItem;
import com.camunda.poc.starter.usecase.order.entity.Order;
import com.camunda.poc.starter.usecase.order.entity.StockItem;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Profile("ordering")
@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Order.class, OrderItem.class, StockItem.class);
    }
}