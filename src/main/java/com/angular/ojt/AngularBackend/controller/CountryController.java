package com.angular.ojt.AngularBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.ojt.AngularBackend.entity.Country;
import com.angular.ojt.AngularBackend.service.CountryService;



@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryService service;
	
	@PostMapping("/save-country")
	public String createCountry(@RequestBody Country country) {
		System.out.println("hi");
		System.out.println("bi");
		System.out.println("india");
		String msg =service.createCountry(country);
		
		return msg;	
	}
	
	@GetMapping("/get-country-by-id/{id}")
	public Country getCountryById(@PathVariable long id) {
		
		Country country = service.getCountryById(id);
		
		return country;
		
	}
	
	@GetMapping("/get-all-country")
	public List<Country> getAllCountry(){
		
		List<Country> list = service.getAllCountry();
		
		return list;
	}
	
	@GetMapping("/get-country-by-name/{cName}")
	public Country getCountryByName(@PathVariable String cName) {
		
		Country country = service.getCountryByName(cName);
		return country;
		
	}
	
	
	@PutMapping("/update-country")
	public String updateCountry(@RequestBody Country country) {
		String updatedcountry = service.updateCountry(country);
		return updatedcountry;
		
	}
	
	@DeleteMapping("/delete-country-by-id/{id}")
	public String deleteCountry(@PathVariable Long id) {
		String deletedcountry = service.deleteCountry(id);
		return deletedcountry;
		
	}
	
	@DeleteMapping("/delete-country-by-name/{name}")
	public String deleteCountry(@PathVariable String Name) {
		String deletedcountryByName = service.deleteCountryByName(Name);
		return deletedcountryByName;
		
	}
	
	
	
	
	
	
	
	
	
}
