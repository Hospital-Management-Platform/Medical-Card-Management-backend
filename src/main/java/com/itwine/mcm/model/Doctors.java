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
@Table(name = "doctors")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Doctors implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "doc_id")
	private long doctorId;

	
	@Column(name = "doc_name")
	private String doctorName;

	@Column(name = "doc_designation")
	private String doctorDesignation ;

	@Column(name = "doc_age")
	private int  doctorAge;

	
	@Column(name = "doc_address")
	private String doctorAddress;

	@Column(name = "doc_specialization")
	private String doctorSpecialization;


	@Column(name = "doc_experience")
	private String doctorExperience;

	@Column(name = "doc_phone")
	private String doctorPhone;

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorDesignation() {
		return doctorDesignation;
	}

	public void setDoctorDesignation(String doctorDesignation) {
		this.doctorDesignation = doctorDesignation;
	}

	public int getDoctorAge() {
		return doctorAge;
	}

	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
	}

	
	public String getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public String getDoctorExperience() {
		return doctorExperience;
	}

	public void setDoctorExperience(String doctorExperience) {
		this.doctorExperience = doctorExperience;
	}

	public String getDoctorPhone() {
		return doctorPhone;
	}

	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}

}
