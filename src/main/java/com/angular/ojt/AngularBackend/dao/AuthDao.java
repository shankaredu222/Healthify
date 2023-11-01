package com.angular.ojt.AngularBackend.dao;

import com.angular.ojt.AngularBackend.entity.Employee;

public interface AuthDao {

	public Employee getUserByUsername(String username);

}
