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
@Table(name = "specialization")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Specialization implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "spec_id")
	private long specializationId;

	
	@Column(name = "spec_name")
	private String specializationName;


	public long getSpecializationId() {
		return specializationId;
	}


	public void setSpecializationId(long specializationId) {
		this.specializationId = specializationId;
	}


	public String getSpecializationName() {
		return specializationName;
	}


	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}


}
