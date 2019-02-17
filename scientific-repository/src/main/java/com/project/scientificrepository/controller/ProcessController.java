package com.project.scientificrepository.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.form.FormField;
import org.camunda.bpm.engine.form.TaskFormData;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.scientificrepository.dto.FormFieldsDto;
import com.project.scientificrepository.dto.FormSubmissionDto;
import com.project.scientificrepository.dto.StringDto;
import com.project.scientificrepository.dto.TaskDto;
import com.project.scientificrepository.dto.Token;

@RestController
@RequestMapping(value = "/process")
public class ProcessController {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private FormService formService;

	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public ResponseEntity<StringDto> startProcess(@RequestBody Token token) {

		System.out.println("USERNAME " + token.getUsername());

		Map<String, Object> starterVariable = new HashMap<>();
		starterVariable.put("starter", token);
		Execution execution = runtimeService.startProcessInstanceByKey("projekat", starterVariable);

		return new ResponseEntity<>(new StringDto(execution.getId()), HttpStatus.OK);
	}


	@PostMapping(path = "/get/tasks")
	public ResponseEntity<List<TaskDto>> get(@RequestBody Token token) {
		
		List<Task> tasks = taskService.createTaskQuery().list();

		List<TaskDto> dtos = new ArrayList<TaskDto>();

		for (Task task : tasks) {
			boolean notTakenLoginTask = task.getName().equals("Logovanje");
			boolean notTakenRegistrationTask = task.getName().equals("Unos podataka za registraciju");
			if (notTakenLoginTask || notTakenRegistrationTask) {
				dtos.add(new TaskDto(task.getId(), task.getName()));
			} else if (token.getUsername() != null)
				if (token.getUsername().equals(task.getAssignee())) {
					dtos.add(new TaskDto(task.getId(), task.getName()));
				}
		}

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@GetMapping(path = "/get/{taskId}", produces = "application/json")
	public @ResponseBody FormFieldsDto get(@PathVariable String taskId) {

		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();

		
		TaskFormData tfd = formService.getTaskFormData(task.getId());
		List<FormField> properties = tfd.getFormFields();
		
		 /* for (FormField fp : properties) { System.out.println(fp.getId() +
		  fp.getType()); }*/
		 

		return new FormFieldsDto(task.getId(), task.getProcessInstanceId(), properties);
	}

	@PostMapping(path = "/submit/{taskId}")
	public @ResponseBody ResponseEntity<StringDto> post(@RequestBody List<FormSubmissionDto> dto,
			@PathVariable String taskId) {
		HashMap<String, Object> map = this.mapListToDto(dto);
		
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		String processInstanceId = task.getProcessInstanceId();

		String processVariable = task.getName().toLowerCase().replace(" ", "_");
		runtimeService.setVariable(processInstanceId, processVariable, dto);
		formService.submitTaskForm(taskId, map);
		return new ResponseEntity<>(new StringDto("success"), HttpStatus.OK);
	}

	private HashMap<String, Object> mapListToDto(List<FormSubmissionDto> list) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		for (FormSubmissionDto temp : list) {
			map.put(temp.getFieldId(), temp.getFieldValue());
		}

		return map;
	}
}
