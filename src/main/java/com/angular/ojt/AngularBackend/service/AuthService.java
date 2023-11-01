package com.angular.ojt.AngularBackend.service;

import java.util.HashMap;

import com.angular.ojt.AngularBackend.entity.Employee;

public interface AuthService {

	public HashMap<String, Employee> loginEmp(String username, String password);

}
