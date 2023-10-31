package com.angular.ojt.AngularBackend.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.ojt.AngularBackend.dao.CountryDao;
import com.angular.ojt.AngularBackend.entity.Country;
import com.angular.ojt.AngularBackend.service.CountryService;


@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao dao;
	
	public String createCountry(Country country) {
		
		return dao.createCountry(country);
	}

	@Override
	public Country getCountryById(long id) {
		
		return dao.getCountryById(id);
	}

	@Override
	public List<Country> getAllCountry() {
		
		return dao.getAllCountry();
	}

	@Override
	public Country getCountryByName(String cName) {
		
		return dao.getCountryByName(cName);
	}

	@Override
	public String updateCountry(Country country) {
		
		return dao.updateCountry(country);
	}

	
	public String deleteCountry(Long id) {
		
		return dao.deleteCountry(id);
	}

	@Override
	public String deleteCountryByName(String name) {
		
		return dao.deleteCountryByName(name);
	}

}
