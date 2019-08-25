package com.itwine.mcm.model;

import java.io.Serializable;

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
@Table(name = "businessentity")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BusinessEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "bsn_id")
	private long businessId;
	
	@Column(name = "bsn_name")
	private String name;

	@Column(name = "bsn_code")
	private String registrationCode;
	
	@Column(name = "bsn_categorycode")
	private String businessCategoryCode;
	
	@Column(name = "bsn_shortname")
	private String shortname;
	
	@Column(name = "bsn_contactperson")
	private String contactPerson;
	
	@Column(name = "bsn_designation")
	private String designation;
	
	@Column(name = "bsn_address1")
	private String address1;
	
	@Column(name = "bsn_address2")
	private String address2;
	
	@Column(name = "bsn_country")
	private String country;
	
	@Column(name = "bsn_state")
	private String state;
	
	@Column(name = "bsn_city")
	private String city;
	
	@Column(name = "bsn_pincode")
	private Integer pincode;
	
	@Column(name = "bsn_mobile")
	private Integer mobile;
	
	@Column(name = "bsn_phone")
	private Integer phone;
	
	@Column(name = "bsn_fax")
	private String fax;
	
	@Column(name = "bsn_accountholdername")
	private String accountHolderName;
	
	@Column(name = "bsn_accountnumber")
	private Integer accountNumber;
	
	@Column(name = "bsn_ifsccode")
	private String  ifscCode;
	
	@Column(name = "bsn_accounttype")
	private String  accountType;
	
	@Column(name = "bsn_bankname")
	private String  bankName;
	
	@Column(name = "bsn_bankbranch")
	private String   bankBranch;
	
	@Column(name = "bsn_offers")
	private String   offers;

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistrationCode() {
		return registrationCode;
	}

	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}

	public String getBusinessCategoryCode() {
		return businessCategoryCode;
	}

	public void setBusinessCategoryCode(String businessCategoryCode) {
		this.businessCategoryCode = businessCategoryCode;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
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

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getOffers() {
		return offers;
	}

	public void setOffers(String offers) {
		this.offers = offers;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}


	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	
	
}
