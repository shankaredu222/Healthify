package com.angular.ojt.AngularBackend.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Employee {

	@Id
	private Long id;

	@Column(nullable = false) 
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	
    //@NotBlank(message = "mobileNumber is required") use @NotBlank instead of @NotNull as @NotBlank will check - 1)String is not null. 2) Trimmed length is greater than zero
	//@Range(min = 10,max= 10, message = "phone_no should be exact 10 characters." )
	
	
	@Column(unique = true, nullable = false) 
	private Long mobPhone;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String gender;

	@Column(nullable = false)
	private String address;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(nullable = false)
	private java.util.Date creationDate;

	@Column(nullable = false)
	private String createdBy;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(nullable = false)
	private java.util.Date updateDate;

	@Column(nullable = false)
	private String updatedBy;

	@Column(nullable = false)
	private String status;

	@OneToOne
	@JoinColumn(name = "countryID")
	private Country countryID;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobPhone() {
		return mobPhone;
	}

	public void setMobPhone(Long mobPhone) {
		this.mobPhone = mobPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public java.util.Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(java.util.Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Country getCountryID() {
		return countryID;
	}

	public void setCountryID(Country countryID) {
		this.countryID = countryID;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", mobPhone=" + mobPhone + ", email=" + email + ", gender=" + gender
				+ ", address=" + address + ", creationDate=" + creationDate + ", createdBy=" + createdBy
				+ ", updateDate=" + updateDate + ", updatedBy=" + updatedBy + ", status=" + status + ", countryID="
				+ countryID + "]";
	}

	
	
	

}
