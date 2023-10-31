package com.angular.ojt.AngularBackend.service;

import java.util.List;

import com.angular.ojt.AngularBackend.entity.Country;

public interface CountryService {

	

public	String createCountry(Country country);

public	Country getCountryById(long id);

public	List<Country> getAllCountry();



public	Country getCountryByName(String cName);

public	String updateCountry(Country country);



public String deleteCountry(Long id);

public String deleteCountryByName(String name);

	
}
