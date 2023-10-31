package com.angular.ojt.AngularBackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {

	@Id
	private long countryID;
	
	@Column(unique = true,nullable = false)
	private String countryName;
	
	public Country() {
		
	}

	public Country(long countryID, String countryName) {
		super();
		this.countryID = countryID;
		this.countryName = countryName;
	}

	public long getCountryID() {
		return countryID;
	}

	public void setCountryID(long countryID) {
		this.countryID = countryID;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Country [countryID=" + countryID + ", countryName=" + countryName + "]";
	}
	
	
}
