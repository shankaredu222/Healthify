package com.angular.ojt.AngularBackend.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.ojt.AngularBackend.entity.Employee;
import com.angular.ojt.AngularBackend.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;

//	@GetMapping("/login")
//	public HashMap loginUser(@RequestBody Employee employee) {
//		HashMap map = service.loginUser(employee);
//		return map;
//	}
	
}
