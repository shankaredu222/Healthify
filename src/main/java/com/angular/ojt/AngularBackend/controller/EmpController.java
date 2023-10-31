package com.angular.ojt.AngularBackend.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.angular.ojt.AngularBackend.entity.Employee;
import com.angular.ojt.AngularBackend.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpService service;
	
	
	
	@PostMapping(value = "/upload-excel-file")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		
		String msg = service.uploadFile(file);
		
		return msg;
	}
	
	@PostMapping("/save-emp")
	public ResponseEntity<Boolean> addemp(@RequestBody @Valid Employee e) {
		System.out.println(e);
		Boolean isAdded =service.addemp(e);
		
		if(isAdded) {
			return new ResponseEntity<Boolean>(isAdded,HttpStatus.CREATED); 
		}else {
			return new ResponseEntity<Boolean>(isAdded,HttpStatus.CONFLICT);
		}
		
	}
	
	@PutMapping("/update-emp")
	public String updateEmp(@RequestBody @Valid Employee e) {
		
		String updatedEmp =service.updateEmp(e);
		return updatedEmp;
		}
	
	@GetMapping("/get-all-emp")
	public ResponseEntity<List<Employee>> getAllEmp(){
		
		List<Employee> list = service.getAllEmp();
		
		if(!list.isEmpty()) {
			return new ResponseEntity<List<Employee>>(list, HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping("/get-emp-by-id/{id}")
	public Employee getEmpById(@PathVariable Long id){
		
		Employee employee = service.getEmpById(id);
		
		return employee;
		
	}
	
	@DeleteMapping("/delete-emp-by-id/{id}")
	public String deleteEmpById(@PathVariable Long id) {
		
		String msg =service.deleteEmpById(id);
		
		
		return msg;
	}
	
	@DeleteMapping("/delete-emp-by-name/{name}")
	public String deleteEmpByName(@PathVariable String name) {
		
		String msg =service.deleteEmpByName(name);
		
		
		return msg;
	}
		
	}
