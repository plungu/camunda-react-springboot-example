package com.camunda.poc.starter;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@SpringBootApplication
@EnableProcessApplication("spring-boot-starter")
public class CamundaApplication extends SpringBootServletInitializer {

	private final Logger LOGGER = Logger.getLogger(CamundaApplication.class.getName());

	public static void main(String... args) { SpringApplication.run(CamundaApplication.class, args); }

}