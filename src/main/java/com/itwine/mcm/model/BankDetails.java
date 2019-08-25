package com.itwine.mcm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;




/**
 * @author SrinivasR
 *
 */

@Entity
@Table(name = "bankdetails")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BankDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "bank_id")
	private long bankId;
	
	@Column(name = "accountholdername")
	private String accountHolderName;
	
	@Column(name = "accountnumber")
	private String accountNumber;
	
	@Column(name = "accounttype")
	private String accountType;
	
	@Column(name = "bankname")
	private String bankName;
	
	@Column(name = "bankbranch")
	private String bankBranch;
	
	@Column(name = "ifsccode")
	private String ifscCode;
	
    @Column(name = "createDateTime")
	private Date creationDate= new Date();
    
    @Column(name = "createdBy")
	private String createdBy;
    
	@Column(name = "modifiedDateTime")
	private Date modifiedDate=new Date();
	
	@Column(name = "modifiedBy")
	private String modifiedBy;

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	
}