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
@Table(name = "businesscategory")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BusinessCategory implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "bsn_categoryId")
	private long businessCategoryId;
	
	@Column(name = "bsn_categoryCode")
	private String businessCategoryCode;
	
	@Column(name = "bsn_categoryName")
	private String businessCategoryName;
	
    @Column(name = "createDateTime")
	private Date creationDate= new Date();
    
    @Column(name = "createdBy")
	private String createdBy;
    
	@Column(name = "modifiedDateTime")
	private Date modifiedDate=new Date();
	
	@Column(name = "modifiedBy")
	private String modifiedBy;

	public long getBusinessCategoryId() {
		return businessCategoryId;
	}

	public void setBusinessCategoryId(long businessCategoryId) {
		this.businessCategoryId = businessCategoryId;
	}

	public String getBusinessCategoryCode() {
		return businessCategoryCode;
	}

	public void setBusinessCategoryCode(String businessCategoryCode) {
		this.businessCategoryCode = businessCategoryCode;
	}

	public String getBusinessCategoryName() {
		return businessCategoryName;
	}

	public void setBusinessCategoryName(String businessCategoryName) {
		this.businessCategoryName = businessCategoryName;
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