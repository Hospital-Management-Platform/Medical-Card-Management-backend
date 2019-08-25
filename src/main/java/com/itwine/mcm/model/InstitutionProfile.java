package com.itwine.mcm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/*import com.fasterxml.jackson.annotation.JsonFormat;*/

/**
 * @author 
 *
 */

@Entity(name="InstitutionProfile")
@Table(name = "institutionprofile")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) 
public class InstitutionProfile implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "institution_id")
	private long institutionId;

	@Column(name = "designation")
	private String instDesignation;

	@Column(name = "address1")
	private String instAddressone;

	@Column(name = "address2")
	private String instAddresstwo;

	@Column(name = "city")
	private String instCity;

	@Column(name = "state")
	private String instState;

	@Column(name = "pincode")
	private String instPincode;

	@Column(name = "country")
	private String instCountryname;

	@Column(name = "fax")
	private String instFax;

	@Column(name = "email")
	private String instEmail;

	@Column(name = "contactPerson")
	private String InstContactPerson;

	@Column(name = "courseOffered")
	private String instCourseOffered;

	@Column(name = "status")
	private Boolean instStatus;

	@Column(name = "courseCode")
	private String instCourseCode;

	@Column(name = "mobile")
	private String instMobile;

	@Column(name = "phone")
	private long instPhone;

	@Column(name = "createdBy")
	private String instCreatedBy;

	@Column(name = "createDateTime")
	private Date instCreateDateTime = new Date();

	@Column(name = " bankBranch")
	private String instBankBranch;


	@Column(name = "modifiedBy")
	private String instModifiedBy;

	@Column(name = "modifiedDateTime")
	private Date instModifiedDateTime = new Date();

	@Column(name = "accountHolderName")
	private String instAccountHolderName;

	@Column(name = "accountNumber")
	private Integer instAccountNumber;

	@Column(name = "ifsccode")
	private String instIfscCode;

	@Column(name = "accountType")
	private String instAccountType;

	@Column(name = "bankName")
	private String instBankName;

	@Column(name = "name")
	private String instName;

	@Column(name = "registrationCode")
	private String instRegistrationCode;

	@Column(name = "branch")
	private String instBranch;

	@Column(name = "shortname")
	private String instShortName;

	@JsonManagedReference
	@OneToMany(mappedBy="institution",cascade=CascadeType.ALL)
	private Set<CourseCategory> courseCategory;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy="institution",cascade=CascadeType.ALL)
	private Set<CourseProfile> courseProfile;
	
	
	public long getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(long institutionId) {
		this.institutionId = institutionId;
	}



	public String getInstDesignation() {
		return instDesignation;
	}



	public void setInstDesignation(String instDesignation) {
		this.instDesignation = instDesignation;
	}



	public String getInstAddressone() {
		return instAddressone;
	}



	public void setInstAddressone(String instAddressone) {
		this.instAddressone = instAddressone;
	}



	public String getInstAddresstwo() {
		return instAddresstwo;
	}



	public void setInstAddresstwo(String instAddresstwo) {
		this.instAddresstwo = instAddresstwo;
	}



	public String getInstCity() {
		return instCity;
	}



	public void setInstCity(String instCity) {
		this.instCity = instCity;
	}



	public String getInstState() {
		return instState;
	}



	public void setInstState(String instState) {
		this.instState = instState;
	}



	public String getInstPincode() {
		return instPincode;
	}



	public void setInstPincode(String instPincode) {
		this.instPincode = instPincode;
	}



	public String getInstCountryname() {
		return instCountryname;
	}



	public void setInstCountryname(String instCountryname) {
		this.instCountryname = instCountryname;
	}



	public String getInstFax() {
		return instFax;
	}



	public void setInstFax(String instFax) {
		this.instFax = instFax;
	}



	public String getInstEmail() {
		return instEmail;
	}



	public void setInstEmail(String instEmail) {
		this.instEmail = instEmail;
	}



	public String getInstContactPerson() {
		return InstContactPerson;
	}



	public void setInstContactPerson(String instContactPerson) {
		InstContactPerson = instContactPerson;
	}



	public String getInstCourseOffered() {
		return instCourseOffered;
	}



	public void setInstCourseOffered(String instCourseOffered) {
		this.instCourseOffered = instCourseOffered;
	}



	public Boolean getInstStatus() {
		return instStatus;
	}



	public void setInstStatus(Boolean instStatus) {
		this.instStatus = instStatus;
	}



	public String getInstCourseCode() {
		return instCourseCode;
	}



	public void setInstCourseCode(String instCourseCode) {
		this.instCourseCode = instCourseCode;
	}



	public String getInstMobile() {
		return instMobile;
	}



	public void setInstMobile(String instMobile) {
		this.instMobile = instMobile;
	}



	public long getInstPhone() {
		return instPhone;
	}



	public void setInstPhone(long instPhone) {
		this.instPhone = instPhone;
	}



	public String getInstCreatedBy() {
		return instCreatedBy;
	}



	public void setInstCreatedBy(String instCreatedBy) {
		this.instCreatedBy = instCreatedBy;
	}



	public Date getInstCreateDateTime() {
		return instCreateDateTime;
	}



	public void setInstCreateDateTime(Date instCreateDateTime) {
		this.instCreateDateTime = instCreateDateTime;
	}



	public String getInstBankBranch() {
		return instBankBranch;
	}



	public void setInstBankBranch(String instBankBranch) {
		this.instBankBranch = instBankBranch;
	}



	public String getInstModifiedBy() {
		return instModifiedBy;
	}



	public void setInstModifiedBy(String instModifiedBy) {
		this.instModifiedBy = instModifiedBy;
	}



	public Date getInstModifiedDateTime() {
		return instModifiedDateTime;
	}



	public void setInstModifiedDateTime(Date instModifiedDateTime) {
		this.instModifiedDateTime = instModifiedDateTime;
	}



	public String getInstAccountHolderName() {
		return instAccountHolderName;
	}



	public void setInstAccountHolderName(String instAccountHolderName) {
		this.instAccountHolderName = instAccountHolderName;
	}



	public Integer getInstAccountNumber() {
		return instAccountNumber;
	}



	public void setInstAccountNumber(Integer instAccountNumber) {
		this.instAccountNumber = instAccountNumber;
	}



	public String getInstIfscCode() {
		return instIfscCode;
	}



	public void setInstIfscCode(String instIfscCode) {
		this.instIfscCode = instIfscCode;
	}



	public String getInstAccountType() {
		return instAccountType;
	}



	public void setInstAccountType(String instAccountType) {
		this.instAccountType = instAccountType;
	}



	public String getInstBankName() {
		return instBankName;
	}



	public void setInstBankName(String instBankName) {
		this.instBankName = instBankName;
	}



	public String getInstName() {
		return instName;
	}



	public void setInstName(String instName) {
		this.instName = instName;
	}



	public String getInstRegistrationCode() {
		return instRegistrationCode;
	}



	public void setInstRegistrationCode(String instRegistrationCode) {
		this.instRegistrationCode = instRegistrationCode;
	}



	public String getInstBranch() {
		return instBranch;
	}



	public void setInstBranch(String instBranch) {
		this.instBranch = instBranch;
	}



	public String getInstShortName() {
		return instShortName;
	}



	public void setInstShortName(String instShortName) {
		this.instShortName = instShortName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@JsonIgnore
	public Set<CourseCategory> getCourseCategory() {
		return courseCategory;
	}
	
	@JsonProperty
	public void setCourseCategory(Set<CourseCategory> courseCategory) {
		this.courseCategory = courseCategory;
	}
	
	
	
	@JsonIgnore
		public Set<CourseProfile> getCourseProfile() {
		return courseProfile;
	}

	@JsonProperty
	public void setCourseProfile(Set<CourseProfile> courseProfile) {
		this.courseProfile = courseProfile;
	}

		public void addCourseCategory(CourseCategory tempCategory) {

		if (getCourseCategory() == null) {
			setCourseCategory(new HashSet());
		}
		getCourseCategory().add(tempCategory);
	}
	
}
