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
@Table(name="membership")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Membership implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="membership_id")
	private long membership_id;
	
	@Column(name="memberName")
	private String memberName;
	
    @Column(name="createdBy")
    private String createdBy;

    @Column(name="createDateTime")
    private Date createDateTime = new Date();

    @Column(name="modifiedBy")
    private String modifiedBy;

    @Column(name="modifiedDateTime")
    private Date modifiedDateTime = new Date();

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

	public long getMembership_id() {
		return membership_id;
	}

	public void setMembership_id(long membership_id) {
		this.membership_id = membership_id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	
	
}
