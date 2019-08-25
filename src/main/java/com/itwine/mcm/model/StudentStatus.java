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
@Table(name="studentstatus")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentStatus implements Serializable {	
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="studentStatus_id")
	private  long studentStatusId;
	
	@Column(name="status")
	private String status;

	public long getStudentStatusId() {
		return studentStatusId;
	}

	public void setStudentStatusId(long studentStatusId) {
		this.studentStatusId = studentStatusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

	