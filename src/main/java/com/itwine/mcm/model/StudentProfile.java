package com.itwine.mcm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "studentprofile")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StudentProfile implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "std_id")
	private long stdId;

	@Column(name = "stdName")
	private String stdName;

	@Column(name = "addressOne")
	private String addressOne;

	@Column(name = "addressTwo")
	private String addressTwo;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zipcode")
	private String zipcode;

	@Column(name = "countryName")
	private String countryName;

	@Column(name = "stdPhone")
	private String stdPhone;

	@Column(name = "gender")
	private String gender;

	@Column(name = "parentPhone")
	private String parentPhone;

	@Column(name = "stdEmail")
	private String stdEmail;

	@Column(name = "stdAdmissionNumber")
	private String stdAdmissionNumber;

	@Column(name = "institutionName")
	private String institutionName;

	@Column(name = "course")
	private String course;

	@Column(name = "stdPassword")
	private String stdPassword;

	/*
	 * @Column(name="std_image_filename") private String stdImage;
	 * 
	 * @Column(name="std_image_filedata") private byte[] stdImageData;
	 */

	@Column(name = "mcmId")
	private String mcmId;
	
	@Column(name = "yearofjoining")
	private String yearofjoining;

	public String getYearofjoining() {
		return yearofjoining;
	}

	public void setYearofjoining(String yearofjoining) {
		this.yearofjoining = yearofjoining;
	}

	public String getCourseCategory() {
		return courseCategory;
	}

	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}


	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name = "courseCategory")
	private String courseCategory;

	@Column(name = "plan")
	private String plan;

	@Column(name = "status")
	private String status;

	public String getMcmId() {
		return mcmId;
	}

	public void setMcmId(String mcmId) {
		this.mcmId = mcmId;
	}

	public String getStdPassword() {
		return stdPassword;
	}

	public void setStdPassword(String stdPassword) {
		this.stdPassword = stdPassword;
	}

	public long getStdId() {
		return stdId;
	}

	public void setStdId(long stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getAddressOne() {
		return addressOne;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}

	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStdEmail() {
		return stdEmail;
	}

	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * public String getStdImage() { return stdImage; }
	 * 
	 * public void setStdImage(String stdImage) { this.stdImage = stdImage; }
	 * 
	 * public byte[] getStdImageData() { return stdImageData; }
	 * 
	 * public void setStdImageData(byte[] stdImageData) { this.stdImageData =
	 * stdImageData; }
	 */
	public String getStdPhone() {
		return stdPhone;
	}

	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getParentPhone() {
		return parentPhone;
	}

	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}

	public String getStdAdmissionNumber() {
		return stdAdmissionNumber;
	}

	public void setStdAdmissionNumber(String stdAdmissionNumber) {
		this.stdAdmissionNumber = stdAdmissionNumber;
	}
}
