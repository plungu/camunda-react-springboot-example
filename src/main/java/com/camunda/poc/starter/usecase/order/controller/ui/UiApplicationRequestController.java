package com.camunda.poc.starter.usecase.order.controller.ui;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Profile("gui")

@Controller
public class UiApplicationRequestController {

	private final Logger LOGGER = Logger.getLogger(Class.class.getName());

	public UiApplicationRequestController() {
	}

	@RequestMapping("/app.html")
	public String index() {
		return "app";
	}

}