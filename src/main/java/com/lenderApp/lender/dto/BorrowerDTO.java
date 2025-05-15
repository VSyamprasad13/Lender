package com.lenderApp.lender.dto;

import java.sql.Date;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BorrowerDTO {
	
	@NotBlank(message = "First name is required")
	@Size(max = 50, message = "First name must be atleast 50 characters")
	private String firstName;
	@Size(max = 50, message = "Middle name must be atleast 50 characters")
	private String middleName;
	@NotBlank(message = "Last name is required")
	@Size(max = 50, message = "Last name must be atleast 50 characters")
	private String lastName;
	private Date dob;
	@Pattern(regexp = "\\d{3}-\\d{2}-\\d{4}",message = "Invalid SSN format (XXX-XX-XXXX)")
	private String socialSecurityNumber;
	@Email(message = "Invalid email format")
	private String email;
	@Pattern(regexp = "^(\\+\\d{1,2}\\s?)?\\d{10}$", message = "Invalid mobile number")
	private Long mobileNumber;
	@Size(max = 50, message = "Address must be atleast 50 characters")
	private String address;
	@Size(max = 50, message = "City must be atleast 50 characters")
	private String city;
	@Size(max = 50, message = "State must be atleast 50 characters")
	private String state;
	@Pattern(regexp = "^[0-9]{6}$", message = "Zipcode contains exactly 6 digits")
	private String zipcode;
	@Size(max = 50, message = "Country must be atleast 50 characters")
	private String country;
	@Enumerated(EnumType.STRING)
	private String employmentStatus;
	@Size(max = 50, message = "Employer name must be atleast 50 characters")
	private String employerName;
	@Size(max = 50, message = "Job title must be atleast 50 characters")
	private String jobTitle;
	@Positive(message = "Annual income must be positive")
	private Double annualIncome;
	@Positive(message = "Experience must be positive")
	private int yearsOfExperience;
	@Positive(message = "Credit Score must be positive")
	private int creditScore;
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getmiddleName() {
		return middleName;
	}
	public void setmiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getsocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public void setsocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getmobileNumber() {
		return mobileNumber;
	}
	public void setmobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(String employment_status) {
		this.employmentStatus = employment_status;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employer_name) {
		this.employerName = employer_name;
	}
	public String getjobTitle() {
		return jobTitle;
	}
	public void setjobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Double getannualIncome() {
		return annualIncome;
	}
	public void setannualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}
	public int getyearsOfExperience() {
		return yearsOfExperience;
	}
	public void setyearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public int getcreditScore() {
		return creditScore;
	}
	public void setcreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

}
