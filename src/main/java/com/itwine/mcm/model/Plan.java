package com.itwine.mcm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@Table(name="plan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Plan implements Serializable {	
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="planname_id")
	private  long plannameId;
	
	@Column(name="planname")
	private String planName;	
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="createDateTime")
	private Date createDateTime = new Date();
	
	@Column(name="modifiedBy")
	private String modifiedBy;
	
	@Column(name="modifiedDateTime")
	private Date modifiedDateTime = new Date();

	public long getPlannameId() {
		return plannameId;
	}

	public void setPlannameId(long plannameId) {
		this.plannameId = plannameId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
}

	