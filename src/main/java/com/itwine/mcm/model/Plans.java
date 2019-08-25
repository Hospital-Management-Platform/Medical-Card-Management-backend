package com.itwine.mcm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;



@SuppressWarnings("serial")
@Entity
@Table(name="plans")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Plans implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="plan_id")
	private long planId;
	
	@Column(name="planName")
	private String planName;
	
	@Column(name="planPrice")
	private long planPrice;
	
	@Column(name="planmembership")
	private String planMembership;
	
	@Column(name="createDateTime")
	private Date createDateTime = new Date();
	
	@Column(name="createdBy")
	private String createdBy;
		
	@Column(name="modifiedDateTime")
	private Date modifiedDateTime = new Date();
	
	@Column(name="modifiedBy")
	private String modifiedBy;
	
	@Column(name="startDateTime")
	private Date startDateTime = new Date();
	
	@Column(name="endDateTime")
	private Date endDateTime = new Date();

	public long getPlanId() {
		return planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public long getPlanPrice() {
		return planPrice;
	}

	public void setPlanPrice(long planPrice) {
		this.planPrice = planPrice;
	}

	public String getPlanMembership() {
		return planMembership;
	}

	public void setPlanMembership(String planMembership) {
		this.planMembership = planMembership;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	
}