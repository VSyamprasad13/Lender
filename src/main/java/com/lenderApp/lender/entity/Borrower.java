package com.lenderApp.lender.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Borrower")
@Entity
@Getter
@Setter @NoArgsConstructor@AllArgsConstructor
public class Borrower{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long borrowerId;
	
	@Column(length = 50, name = "firstName")
	private String firstName;
	@Size(min = 25)
	private String middleName;
	@Column(length = 50)
	private String lastName;
	private Date dob;
	@Column(unique = true)
	private String socialSecurityNumber;
	@Column(unique = true)
	@NotNull
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

	@OneToMany(mappedBy = "borrower", cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<CoBorrower> coBorrowers;
	
	@OneToMany(mappedBy = "borrower", cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Property> property;
	
	@OneToMany(mappedBy = "borrower", cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Liabilities> liability;
	
	@OneToMany(mappedBy = "borrower", cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Assets> assets;

	public Long getBorrowerid() {
		return borrowerId;
	}

	public void setBorrowerid(Long borrowerid) {
		this.borrowerId = borrowerid;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public String getMiddlename() {
		return middleName;
	}

	public void setMiddlename(String middlename) {
		this.middleName = middlename;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSocialsecuritynumber() {
		return socialSecurityNumber;
	}

	public void setSocialsecuritynumber(String socialsecuritynumber) {
		this.socialSecurityNumber = socialsecuritynumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobilenumber() {
		return mobileNumber;
	}

	public void setMobilenumber(Long mobilenumber) {
		this.mobileNumber = mobilenumber;
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

	public String getEmploymentstatus() {
		return employmentStatus;
	}

	public void setEmploymentstatus(String employmentstatus) {
		this.employmentStatus = employmentstatus;
	}

	public String getEmployername() {
		return employerName;
	}

	public void setEmployername(String employername) {
		this.employerName = employername;
	}

	public String getJobtitle() {
		return jobTitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobTitle = jobtitle;
	}

	public Double getAnnualincome() {
		return annualIncome;
	}

	public void setAnnualincome(Double annualincome) {
		this.annualIncome = annualincome;
	}

	public int getYearsofexperience() {
		return yearsOfExperience;
	}

	public void setYearsofexperience(int yearsofexperience) {
		this.yearsOfExperience = yearsofexperience;
	}

	public int getCreditscore() {
		return creditScore;
	}

	public void setCreditscore(int creditscore) {
		this.creditScore = creditscore;
	}

	public List<CoBorrower> getCoBorrowers() {
		return coBorrowers;
	}

	public void setCoBorrowers(List<CoBorrower> coBorrowers) {
		this.coBorrowers = coBorrowers;
	}

	public List<Property> getProperty() {
		return property;
	}

	public void setProperty(List<Property> property) {
		this.property = property;
	}

	public List<Liabilities> getLiability() {
		return liability;
	}

	public void setLiability(List<Liabilities> liability) {
		this.liability = liability;
	}

	public List<Assets> getAssets() {
		return assets;
	}

	public void setAssets(List<Assets> assets) {
		this.assets = assets;
	}
	
	public String getFullName() {
		return this.firstName+" "+this.lastName;
	}

}
