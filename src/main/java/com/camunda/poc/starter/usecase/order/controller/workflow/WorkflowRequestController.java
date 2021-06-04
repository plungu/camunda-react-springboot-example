package com.camunda.poc.starter.usecase.order.controller.workflow;

import com.camunda.poc.starter.entity.Employee;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Profile("ordering")
@Controller
public class WorkflowRequestController {

	private final Logger LOGGER = Logger.getLogger(Class.class.getName());

	public WorkflowRequestController() {
	}

	private RuntimeService runtimeService;
	private TaskService taskService;

	@Autowired
	public WorkflowRequestController(RuntimeService runtimeService,
									 TaskService taskService)
	{

		this.runtimeService = runtimeService;
		this.taskService = taskService;
	}

	@RequestMapping(value = "/sr/start/workflow", method = RequestMethod.POST, consumes = {"application/json"})
	public ResponseEntity<HttpStatus> start(@RequestBody(required = false) Employee requestEntity)
	{
		LOGGER.info("\n\n Start Workflow"+ requestEntity);

		Map<String, Object> variables = new HashMap();
		variables.put("approved", false);

		runtimeService.correlateMessage("web-form-submission", requestEntity.getEmail(), variables);
		ResponseEntity<HttpStatus> response = new ResponseEntity<HttpStatus>(HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/approveOrder", method = RequestMethod.GET)
	public String approveOrder(@RequestParam("businessKey") String businessKey,
							   @RequestParam("approved") boolean approved) {

		Map<String, Object> taskVariables = new HashMap<>();
		taskVariables.put("approved", approved);

		finishTask(businessKey, taskVariables);

		return "splash";
	}

	@RequestMapping(value = "/approveStockReplenishment", method = RequestMethod.GET)
	public String approveStockReplenishment(@RequestParam("businessKey") String businessKey,
											@RequestParam("approved") boolean approved) {

		Map<String, Object> taskVariables = new HashMap<>();
		taskVariables.put("approved", approved);

		finishTask(businessKey, taskVariables);

		return "replenish";
	}

	@RequestMapping(value = "/completeOrderReviewTask", method = RequestMethod.GET)
	public String completeOrderReviewTask(@RequestParam("businessKey") String businessKey,
											@RequestParam("approved") boolean approved) {

		Map<String, Object> taskVariables = new HashMap<>();
		taskVariables.put("approved", approved);

		finishTask(businessKey, taskVariables);

		return "approval";
	}



	private  void finishTask(String businessKey, Map taskVariables){

			Task task = taskService.createTaskQuery()
					.processInstanceBusinessKey(businessKey)
					.active()
					.singleResult();

			taskService.complete(task.getId(), taskVariables);
	}

}