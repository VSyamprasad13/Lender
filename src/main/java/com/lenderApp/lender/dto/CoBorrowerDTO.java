package com.lenderApp.lender.dto;

import java.sql.Date;

import com.lenderApp.lender.entity.Borrower;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


public class CoBorrowerDTO {

	private Long coBorrowerId;
	private Borrower borrower;
	@NotBlank(message = "First name is required")
	@Size(max = 50, message = "First name must be atleast 50 characters")
	private String firstName;
	@Size(max = 50, message = "Middle name must be atleast 50 characters")
	private String middleName;
	@NotBlank(message = "First name is required")
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
	
	public Long getCoBorrowerId() {
		return coBorrowerId;
	}
	public void setCoBorrowerId(Long coBorrowerId) {
		this.coBorrowerId = coBorrowerId;
	}
	public Borrower getBorrower() {
		return borrower;
	}
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
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
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	
	

}
