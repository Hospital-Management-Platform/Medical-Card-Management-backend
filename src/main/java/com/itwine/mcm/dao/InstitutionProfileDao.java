package com.itwine.mcm.dao;

import java.util.List;

import com.itwine.mcm.model.CourseCategory;
import com.itwine.mcm.model.CourseProfile;
import com.itwine.mcm.model.InstitutionProfile;



public interface InstitutionProfileDao {
	public boolean addInstitution(InstitutionProfile institutionProfile) throws Exception;
	public InstitutionProfile getInstitutionById(long id) throws Exception;
	public List<InstitutionProfile> getInstitutionList() throws Exception;
	public boolean deleteInstitution(long id) throws Exception;
	public void update(long id, InstitutionProfile institutionProfile);
	

	public List<InstitutionProfile> searchInstitutionProfile(InstitutionProfile institutionProfile) throws Exception;
	List<InstitutionProfile> getCourseCategoryList1(CourseCategory courseProfile);
}
