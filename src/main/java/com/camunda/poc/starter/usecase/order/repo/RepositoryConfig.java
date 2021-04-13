package com.camunda.poc.starter.usecase.order.repo;

import com.camunda.poc.starter.usecase.order.entity.OrderItem;
import com.camunda.poc.starter.usecase.order.entity.Order;
import com.camunda.poc.starter.usecase.order.entity.StockItem;
import com.camunda.poc.starter.entity.Contact;

import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Configuration;

@Profile("ordering")
@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

  @Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Order.class, OrderItem.class, StockItem.class, Contact.class);
  }

}
