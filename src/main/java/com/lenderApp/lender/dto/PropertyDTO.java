package com.lenderApp.lender.dto;

import java.util.Date;

import com.lenderApp.lender.entity.Borrower;

public class PropertyDTO {

	private Long propertyId;
	private Borrower borrower;
	private String propertyAddress;
	private String propertyCity;
	private String propertyState;
	private String propertyZipCode;
	private String propertyType;
	private Date yearBuilt;
	private double squareFootage;
	private double lotSize;
	private double estimatedValue;
	private double mortgageBalance;
	private String ownedOrRent;
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	public Borrower getBorrower() {
		return borrower;
	}
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	public String getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
	public String getPropertyCity() {
		return propertyCity;
	}
	public void setPropertyCity(String propertyCity) {
		this.propertyCity = propertyCity;
	}
	public String getPropertyState() {
		return propertyState;
	}
	public void setPropertyState(String propertyState) {
		this.propertyState = propertyState;
	}
	public String getPropertyZipCode() {
		return propertyZipCode;
	}
	public void setPropertyZipCode(String propertyZipCode) {
		this.propertyZipCode = propertyZipCode;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public Date getYearBuilt() {
		return yearBuilt;
	}
	public void setYearBuilt(Date yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	public double getSquareFootage() {
		return squareFootage;
	}
	public void setSquareFootage(double squareFootage) {
		this.squareFootage = squareFootage;
	}
	public double getLotSize() {
		return lotSize;
	}
	public void setLotSize(double lotSize) {
		this.lotSize = lotSize;
	}
	public double getEstimatedValue() {
		return estimatedValue;
	}
	public void setEstimatedValue(double estimatedValue) {
		this.estimatedValue = estimatedValue;
	}
	public double getMortgageBalance() {
		return mortgageBalance;
	}
	public void setMortgageBalance(double mortgageBalance) {
		this.mortgageBalance = mortgageBalance;
	}
	public String getOwnedOrRent() {
		return ownedOrRent;
	}
	public void setOwnedOrRent(String ownedOrRent) {
		this.ownedOrRent = ownedOrRent;
	}
	
}
