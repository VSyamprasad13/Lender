package com.lenderApp.lender.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CoBorrower")
@Getter
@Setter
public class CoBorrower {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long coBorrowerId;
	@ManyToOne
	@JoinColumn(name = "borrowerId")
	@JsonBackReference
	private Borrower borrower;
	@Column(length = 50)
	private String firstName;
	
	private String middleName;
	@Column(length = 50)
	private String lastName;
	private Date dob;
	@Column(unique = true)
	private String socialSecurityNumber;
	@Column(unique = true)
	private String email;
	private Long mobileNumber;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private String employmentStatus;
	private String employerName;
	private String jobTitle;
	private Double annualIncome;
	private int yearsOfExperience;
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
	public String getEmployment_status() {
		return employmentStatus;
	}
	public void setEmployment_status(String employment_status) {
		this.employmentStatus = employment_status;
	}
	public String getEmployer_name() {
		return employerName;
	}
	public void setEmployer_name(String employer_name) {
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
