package com.lenderApp.lender.dto;

import com.lenderApp.lender.entity.Borrower;

public class AssetsDTO {

	private Long assetId;
	private Borrower borrowerId;
	
	private String assetType;
	private String assetName;
	private Double accountBalance;
	private String accountName;
	private String institutionName;
	private boolean isJointAccount;
	public Long getAssetId() {
		return assetId;
	}
	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}
	public Borrower getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(Borrower borrowerId) {
		this.borrowerId = borrowerId;
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
