package com.lenderApp.lender.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "users")
@Entity
public class Users {
	
	@Id
	@Column(unique = true)
	private Long userID;
	
	private String borrowerName;
	
	@OneToOne
	@JoinColumn(name="borrowerId",unique = true)
	@JsonBackReference
	private Borrower borrower;
	
	private String role;
	
	
	public Users() {}

	public Users(Long userID, String borrowerName, Borrower borrower) {
		this.userID = userID;
		this.borrowerName = borrowerName;
		this.borrower = borrower;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
