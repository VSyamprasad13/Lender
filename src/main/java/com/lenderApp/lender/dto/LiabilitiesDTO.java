package com.lenderApp.lender.dto;

import java.util.Date;

import com.lenderApp.lender.entity.Borrower;

public class LiabilitiesDTO {

	private int liabilityId;
	private Borrower borrower;
	private String liabilityType;
	private String creditorName;
	private double outstandingBalance;
	private double monthlyPayment;
	private double interestRate;
	private Date dueDate;
	
	public int getLiabilityId() {
		return liabilityId;
	}
	public Borrower getBorrower() {
		return borrower;
	}
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	public String getLiabilityType() {
		return liabilityType;
	}
	public void setLiabilityType(String liabilityType) {
		this.liabilityType = liabilityType;
	}
	public String getCreditorName() {
		return creditorName;
	}
	public void setCreditorName(String creditorName) {
		this.creditorName = creditorName;
	}
	public double getOutstandingBalance() {
		return outstandingBalance;
	}
	public void setOutstandingBalance(double outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
