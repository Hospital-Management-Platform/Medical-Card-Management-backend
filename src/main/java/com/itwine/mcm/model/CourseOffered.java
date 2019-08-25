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
@Table(name="courseoffered")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CourseOffered implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="courseOffered_id")
	private long courseOffered_id;
	
	@Column(name="courseCode")
	private String courseCode;
	
	@Column(name="status")
	private String status;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="createDateTime")
	private Date createDateTime = new Date();
	
	@Column(name="modifiedBy")
	private String modifiedBy;
	
	@Column(name="modifiedDateTime")
	private Date modifiedDateTime = new Date();

	public long getCourseOffered_id() {
		return courseOffered_id;
	}

	public void setCourseOffered_id(long courseOffered_id) {
		this.courseOffered_id = courseOffered_id;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	

}
