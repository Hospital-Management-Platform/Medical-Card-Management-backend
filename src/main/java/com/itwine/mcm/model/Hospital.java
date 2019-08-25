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
@Table(name = "hospital")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Hospital implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "hospital_id")
	private long hospitalId;

	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	@Column(name = "hospital_name")
	private String hospitalName;
	

	@Column(name = "hospital_address1")
	private String hospitalAddress1;

	@Column(name = "hospital_phone")
	private String hospitalPhone;

	@Column(name = "doctor")
	private String doctor;
	
	@Column(name = "treatment_available")
	private String treatmentAvailable;

	@Column(name = "doctor_specialist")
	private String doctorSpecialist;
	
	@Column(name = "hospital_address2")
	private String hospitalAddress2;
	
	@Column(name = "hosp_country")
	private String country;
	
	@Column(name = "hosp_state")
	private String state;
	
	@Column(name = "hosp_city")
	private String city;
	
	@Column(name = "hosp_zipcode")
	private String zipcode;
	
	@Column(name = "hosp_specilities")
	private String specilities;
	
	
	
	public long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	
	public String getHospitalAddress1() {
		return hospitalAddress1;
	}
	public void setHospitalAddress1(String hospitalAddress1) {
		this.hospitalAddress1 = hospitalAddress1;
	}
	public String getHospitalPhone() {
		return hospitalPhone;
	}
	public void setHospitalPhone(String hospitalPhone) {
		this.hospitalPhone = hospitalPhone;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getTreatmentAvailable() {
		return treatmentAvailable;
	}
	public void setTreatmentAvailable(String treatmentAvailable) {
		this.treatmentAvailable = treatmentAvailable;
	}
	public String getDoctorSpecialist() {
		return doctorSpecialist;
	}
	public void setDoctorSpecialist(String doctorSpecialist) {
		this.doctorSpecialist = doctorSpecialist;
	}
	public String getHospitalAddress2() {
		return hospitalAddress2;
	}
	public void setHospitalAddress2(String hospitalAddress2) {
		this.hospitalAddress2 = hospitalAddress2;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSpecilities() {
		return specilities;
	}
	public void setSpecilities(String specilities) {
		this.specilities = specilities;
	}
	
	
}
