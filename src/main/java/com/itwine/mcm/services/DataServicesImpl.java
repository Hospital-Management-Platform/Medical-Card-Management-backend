package com.itwine.mcm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.dao.AttributeDao;
import com.itwine.mcm.dao.BankDetailsDao;
import com.itwine.mcm.dao.BusinessCategoryDao;
import com.itwine.mcm.dao.BusinessEntityDao;
import com.itwine.mcm.dao.CourseCategoryDao;

import com.itwine.mcm.dao.DoctorsDao;
import com.itwine.mcm.dao.HospitalDao;
import com.itwine.mcm.dao.InstitutionProfileDao;
import com.itwine.mcm.dao.SpecializationDao;
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



public class DataServicesImpl implements DataServices {

	@Autowired
	InstitutionProfileDao institutionProfileDao;
	
	
	@Autowired
	HospitalDao hospitalDao;
	
	@Autowired
	DoctorsDao doctorsDao;
	
	@Autowired
	SpecializationDao specializationDao;
	
	@Autowired
	BusinessEntityDao businessEntityDao;
	
	@Autowired
	CourseCategoryDao courseCategoryDao;
	
	@Autowired
	BankDetailsDao  bankDetailsDao;
	
	@Autowired
	BusinessCategoryDao businessCategoryDao;
	
	@Autowired
	AttributeDao attributeDao;
	
	
	@Override
	public boolean addInstitution(InstitutionProfile institutionProfile) throws Exception {
 		return institutionProfileDao.addInstitution(institutionProfile);
	
	}

	@Override
	public InstitutionProfile  getInstitutionById(long id) throws Exception {
		return institutionProfileDao.getInstitutionById(id);
	}

	 
	
	@Override
	public List<InstitutionProfile> getInstitutionList()  throws Exception {
		return institutionProfileDao.getInstitutionList();
	}

	@Override
	public boolean deleteInstitution(long id) throws Exception {
		return institutionProfileDao.deleteInstitution(id);
	}
	
	@Override
	public void update(long id, InstitutionProfile institutionProfile) {
		 institutionProfileDao.update(id, institutionProfile);
	}
	
	@Override
	public List<InstitutionProfile> getCourseCategoryList1(CourseCategory courseCategory) {
		return institutionProfileDao.getCourseCategoryList1(courseCategory);
	}


	
	

	
	
	
	
	@Override
	public boolean addCourseCategory(CourseCategory courseCategory) throws Exception {
		return courseCategoryDao.addCourseCategory(courseCategory);
	
	}

	@Override
	public CourseCategory  getCourseCategoryById(long id) throws Exception {
		return courseCategoryDao.getCourseCategoryById(id);
	}

	@Override
	public List<CourseCategory> getCourseCategoryList()  throws Exception {
		return courseCategoryDao.getCourseCategoryList();
	}

	@Override
	public boolean deleteCourseCategory(long id) throws Exception {
		return courseCategoryDao.deleteCourseCategory(id);
	}

	@Override
	public List<CourseCategory> getCourseList2(CourseProfile courseProfile) {
		return courseCategoryDao.getCourseList2(courseProfile);
	}

	
	
	@Override
	public boolean addHospital(Hospital hospital) throws Exception {
		return hospitalDao.addHospital(hospital);
	
	}

	@Override
	public Hospital  getHospitalById(long id) throws Exception {
		return hospitalDao.getHospitalById(id);
	}

	@Override
	public List<Hospital> getHospitalList()  throws Exception {
		return hospitalDao.getHospitalList();
	}

	@Override
	public boolean deleteHospital(long id) throws Exception {
		return hospitalDao.deleteHospital(id);
	}
	
	
	@Override
	public boolean addBusinessEntity(BusinessEntity businessEntity) throws Exception {
		return businessEntityDao.addBusinessEntity(businessEntity);
	
	}
	@Override
	public BusinessEntity  getBusinessEntityById(long id) throws Exception {
		return businessEntityDao.getBusinessEntityById(id);
	}
	
	@Override
	public List<BusinessEntity> getBusinessEntityList()  throws Exception {
		return businessEntityDao.getBusinessEntityList();
	}

	@Override
	public boolean deleteBusinessEntity(long id) throws Exception {
		return businessEntityDao.deleteBusinessEntity(id);
	}

	
	/*@Override
	public Boolean findByEmail(String businessEmail) {
		return businessEntityDao.findEmail(businessEmail);
	}*/
	
	@Override
	public boolean addDoctor(Doctors doctor) throws Exception {
		return doctorsDao.addDoctor(doctor);
	
	}

	@Override
	public Doctors  getDoctorById(long id) throws Exception {
		return doctorsDao.getDoctorById(id);
	}

	@Override
	public List<Doctors> getDoctorsList()  throws Exception {
		return doctorsDao.getDoctorsList();
	}

	@Override
	public boolean deleteDoctor(long id) throws Exception {
		return doctorsDao.deleteDoctor(id);
	}
	
	
	@Override
	public boolean addSpecialization(Specialization specialization) throws Exception {
		return specializationDao.addSpecialization(specialization);
	
	}

	@Override
	public Specialization  getSpecializationById(long id) throws Exception {
		return specializationDao.getSpecializationById(id);
	}

	@Override
	public List<Specialization> getSpecializationList()  throws Exception {
		return specializationDao.getSpecializationList();
	}

	@Override
	public boolean deleteSpecialization(long id) throws Exception {
		return specializationDao.deleteSpecialization(id);
	}
	
	@Override
	public boolean addBankDetails(BankDetails bankDetails) throws Exception {
		return bankDetailsDao.addBankDetails(bankDetails);
	
	}

	@Override
	public BankDetails  getBankDetailsById(long id) throws Exception {
		return bankDetailsDao.getBankDetailsById(id);
	}

	@Override
	public List<BankDetails> getBankDetailsList()  throws Exception {
		return bankDetailsDao.getBankDetailsList();
	}

	@Override
	public boolean deleteBankDetails(long id) throws Exception {
		return bankDetailsDao.deleteBankDetails(id);
	}
	
	@Override
	public void update(long id, CourseCategory courseCategory) {
		courseCategoryDao.update(id, courseCategory);
		
	}
	
	
	@Override
	public boolean addBusinessCategory(BusinessCategory businessCategory) throws Exception {
		return businessCategoryDao.addBusinessCategory(businessCategory);
	
	}

	@Override
	public BusinessCategory  getBusinessCategoryById(long id) throws Exception {
		return businessCategoryDao.getBusinessCategoryById(id);
	}

	@Override
	public List<BusinessCategory> getBusinessCategoryList()  throws Exception {
		return businessCategoryDao.getBusinessCategoryList();
	}

	@Override
	public boolean deleteBusinessCategory(long id) throws Exception {
		return businessCategoryDao.deleteBusinessCategory(id);
	}
	@Override
	public void update(long id, BusinessCategory businessCategory) {
		businessCategoryDao.update(id, businessCategory);
		
	}
	@Override
	public void update(long id, BusinessEntity BusinessEntity) {
		businessEntityDao.update(id, BusinessEntity);
		
	}
	
	@Override
	public boolean addAttribute(Attribute attribute) throws Exception {
		// TODO Auto-generated method stub
		return attributeDao.addAttribute(attribute);
	}

	@Override
	public Attribute getAttributeById(long id) throws Exception {
		// TODO Auto-generated method stub
		return attributeDao.getAttributeById(id);
	}

	@Override
	public List<Attribute> getAttributeList() throws Exception {
		// TODO Auto-generated method stub
		return attributeDao.getAttributeList();
	}

	@Override
	public boolean deleteAttribute(long id) throws Exception {
		// TODO Auto-generated method stub
		return attributeDao.deleteAttribute(id);
	}

	@Override
	public void update(long id, Attribute attribute) {
		 attributeDao.update(id, attribute);
		
	}

	@Override
	public List<InstitutionProfile> searchInstitutionProfile(InstitutionProfile institutionProfile) throws Exception {
		return institutionProfileDao.searchInstitutionProfile(institutionProfile);
	}

	@Override
	public List<CourseCategory> searchCourseCategory(CourseCategory courseCategory) throws Exception {
		return courseCategoryDao.searchCourseCategory(courseCategory);
	}
	
}
