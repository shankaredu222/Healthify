package com.angular.ojt.AngularBackend.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.angular.ojt.AngularBackend.entity.Employee;
import com.angular.ojt.AngularBackend.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService service;
	
	@GetMapping("/login")
	public ResponseEntity<HashMap<String, Employee>> loginEmp(@RequestParam String username,@RequestParam String password ) {
		 HashMap<String, Employee> empMap = service.loginEmp(username,password);
		 HttpStatus httpStatus = HttpStatus.OK;
		 if(empMap.containsKey("Employee Not found Please check username")) {
			 httpStatus=HttpStatus.NOT_FOUND;
		 }else if (empMap.containsKey("The given Password is Incorrect")) {
			httpStatus=HttpStatus.UNAUTHORIZED;
		}
		 return new ResponseEntity<>(empMap, httpStatus);
	}
	
}
