package com.angular.ojt.AngularBackend.serviceIMPL;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.ojt.AngularBackend.dao.RegistrationDao;
import com.angular.ojt.AngularBackend.entity.Employee;
import com.angular.ojt.AngularBackend.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {


	@Autowired
	private RegistrationDao dao;
	
//	@Override
//	public HashMap loginUser(Employee employee) {
//		
//		Employee user = dao.loginUser(employee);
//		
//		HashMap  map = new HashMap();
//		
//		if(user!=null) {
//			if(employee.getUsername().equals(user.getUsername())) {
//				map.put("msg", "VALID USER");
//			}
//			
//		}else {
//			map.put("msg", "INVALID USER");
//		}
//		map.put("user", user);
//		return map;
//	}

	
	
	
	

}
