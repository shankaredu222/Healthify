package com.angular.ojt.AngularBackend.serviceIMPL;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.ojt.AngularBackend.dao.AuthDao;
import com.angular.ojt.AngularBackend.entity.Employee;
import com.angular.ojt.AngularBackend.service.AuthService;

@Service
public class AuthServiceIMPL implements AuthService {
	
	@Autowired
	private AuthDao dao;

	@Override
	public HashMap<String, Employee> loginEmp(String username, String password) {
		
		Employee emp = dao.getUserByUsername(username);
		HashMap<String, Employee> map = new HashMap<>();
		String msg = null;
		if(emp==null)
		{
			msg ="Employee Not found Please check username";
			map.put(msg, null);
		}
		else if(emp.getPassword().equals(password)) {
			msg ="Login Successfull";
			map.put(msg, emp);
		}else if(emp.getPassword()!= password) {
			msg ="The given Password is Incorrect";
			map.put(msg, null);
		}
		
		
		return map;
	}

}
