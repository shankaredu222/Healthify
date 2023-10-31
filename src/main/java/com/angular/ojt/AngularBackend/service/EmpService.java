package com.angular.ojt.AngularBackend.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.angular.ojt.AngularBackend.entity.Country;
import com.angular.ojt.AngularBackend.entity.Employee;

public interface EmpService {

	public String updateEmp(Employee e);

	public String deleteEmpById(Long id);

	public String deleteEmpByName(String name);

	public List<Employee> getAllEmp();

	public Employee getEmpById(Long id);

	public Boolean addemp(@Valid Employee e);

	public String uploadFile(MultipartFile file);



	

}
