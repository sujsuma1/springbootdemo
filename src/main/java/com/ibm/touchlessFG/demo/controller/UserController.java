package com.ibm.touchlessFG.demo.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.touchlessFG.demo.Model.Executions;
import com.ibm.touchlessFG.demo.Model.Users;
import com.ibm.touchlessFG.demo.ServiceImpl.ExecutionsService;
import com.ibm.touchlessFG.demo.ServiceImpl.UserService;

@RestController
@RequestMapping("/Users")
public class UserController {

	public UserController(UserService userService, ExecutionsService executionsService) {
		this.userService = userService;
		this.executionsService = executionsService;
	}

	@Autowired
	private UserService userService;
	private final ExecutionsService executionsService;
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public Users getUsers(@RequestParam(required = true) final String userId) {
		
		return userService.findOneByName(userId);
	}

	@PostMapping(value = "/processes", consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> upsertBusinessProcesses() {
		Executions exec;
		exec = new Executions();

		exec.setExecutionName("test");
		exec.setUsername("Sujay");
		exec.setCreatedBy("Sujay");

		exec.setExecutionstatus("In progress");

		executionsService.save(exec);
		return new ResponseEntity<>(CREATED);
	}
}
