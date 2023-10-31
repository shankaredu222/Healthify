package com.angular.ojt.AngularBackend.dao;

import java.util.List;

import javax.validation.Valid;

import com.angular.ojt.AngularBackend.entity.Country;
import com.angular.ojt.AngularBackend.entity.Employee;

public interface EmpDao {

	

	public String updateEmp(Employee e);

	public String deleteEmpById(Long id);

	public String deleteEmpByName(String name);

	public List<Employee> getAllEmp();

	public Employee getEmpById(Long id);

	public Boolean addemp(@Valid Employee e);

	public String uploadSheet(List<Employee> readExcelFile);



	

}
