package com.camunda.poc.starter;

import com.camunda.poc.starter.bpm.ExternalTaskClientImpl;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableProcessApplication("spring-boot-starter")
public class CamundaApplication extends SpringBootServletInitializer {

	public static void main(String... args) {

		ConfigurableApplicationContext context = SpringApplication.run(CamundaApplication.class, args);

		context.getBean(ExternalTaskClientImpl.class).execute();

	}

}

