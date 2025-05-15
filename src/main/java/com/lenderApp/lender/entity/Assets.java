package com.lenderApp.lender.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "Assets")
@Entity
public class Assets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assetId;
	@ManyToOne
	@JoinColumn(name = "borrowerId", nullable = false)
	@JsonBackReference
	private Borrower borrower;
	private String assetType;
	private String assetName;
	private Double accountBalance;
	private String accountName;
	private String institutionName;
	private boolean isJointAccount;
	
	public Long getAssetId() {
		return assetId;
	}
	public void setAsset_id(Long assetId) {
		this.assetId = assetId;
	}
	public Borrower getBorrower() {
		return borrower;
	}
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public boolean isJointAccount() {
		return isJointAccount;
	}
	public void setJointAccount(boolean isJointAccount) {
		this.isJointAccount = isJointAccount;
	}
	
	
}
