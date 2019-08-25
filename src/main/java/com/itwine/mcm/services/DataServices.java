package com.itwine.mcm.services;

import java.util.List;

import com.itwine.mcm.model.Attribute;
import com.itwine.mcm.model.BankDetails;
import com.itwine.mcm.model.BusinessCategory;
import com.itwine.mcm.model.BusinessEntity;
import com.itwine.mcm.model.CourseCategory;
import com.itwine.mcm.model.CourseProfile;
import com.itwine.mcm.model.Doctors;
import com.itwine.mcm.model.Hospital;
import com.itwine.mcm.model.InstitutionProfile;
import com.itwine.mcm.model.Specialization;



public interface DataServices {
	

	public boolean addInstitution(InstitutionProfile institutionProfile) throws Exception;
	public InstitutionProfile getInstitutionById(long id) throws Exception;
	public List<InstitutionProfile> getInstitutionList() throws Exception;
	public boolean deleteInstitution(long id) throws Exception;
	public void update(long id, InstitutionProfile institutionProfile);
	List<InstitutionProfile> getCourseCategoryList1(CourseCategory courseCategory);

	public List<InstitutionProfile> searchInstitutionProfile(InstitutionProfile institutionProfile) throws Exception;
	
	
	public boolean addCourseCategory(CourseCategory courseCategory) throws Exception;
	public CourseCategory getCourseCategoryById(long id) throws Exception;
	public List<CourseCategory> getCourseCategoryList() throws Exception;
	public boolean deleteCourseCategory(long id) throws Exception;
	public void update(long id, CourseCategory courseCategory);
	public List<CourseCategory> getCourseList2(CourseProfile courseProfile);
	public List<CourseCategory> searchCourseCategory(CourseCategory courseCategory) throws Exception;
	
	public boolean addHospital(Hospital hospital) throws Exception;
	public Hospital getHospitalById(long id) throws Exception;
	public List<Hospital> getHospitalList() throws Exception;
	public boolean deleteHospital(long id) throws Exception;
	
	
/*	public boolean addBusinessEntity(BusinessEntity businessEntity) throws Exception;*/
	public BusinessEntity getBusinessEntityById(long id) throws Exception;
	public List<BusinessEntity> getBusinessEntityList() throws Exception;
	public boolean deleteBusinessEntity(long id) throws Exception;
	boolean addBusinessEntity(BusinessEntity businessEntity) throws Exception;
	public void update(long id, BusinessEntity BusinessEntity);
	
	
	public boolean addDoctor(Doctors doctor) throws Exception;
	public Doctors getDoctorById(long id) throws Exception;
	public List<Doctors> getDoctorsList() throws Exception;
	public boolean deleteDoctor(long id) throws Exception;
	
	public boolean addSpecialization(Specialization specialization) throws Exception;
	public Specialization getSpecializationById(long id) throws Exception;
	public List<Specialization> getSpecializationList() throws Exception;
	public boolean deleteSpecialization(long id) throws Exception;
	/*Boolean findByEmail(String businessEmail);*/
	
	public boolean addBankDetails(BankDetails bankDetails) throws Exception;
	public BankDetails getBankDetailsById(long id) throws Exception;
	public List<BankDetails> getBankDetailsList() throws Exception;
	public boolean deleteBankDetails(long id) throws Exception;
	
	public boolean addBusinessCategory(BusinessCategory businessCategory) throws Exception;
	public BusinessCategory getBusinessCategoryById(long id) throws Exception;
	public List<BusinessCategory> getBusinessCategoryList() throws Exception;
	public boolean deleteBusinessCategory(long id) throws Exception;
	public void update(long id, BusinessCategory BusinessCategory);
	
	public boolean addAttribute(Attribute attribute) throws Exception;
	public Attribute getAttributeById(long id) throws Exception;
	public List<Attribute> getAttributeList() throws Exception;
	public boolean deleteAttribute(long id) throws Exception;
	public void update(long id, Attribute attribute);
	
	
	
	
	
	
}
