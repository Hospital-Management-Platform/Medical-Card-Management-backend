package com.itwine.mcm.daoimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.itwine.mcm.model.CourseCategory;
import com.itwine.mcm.model.CourseProfile;
import com.itwine.mcm.model.InstitutionProfile;
import com.itwine.mcm.dao.InstitutionProfileDao;


public class InstitutionProfileDaoImpl implements InstitutionProfileDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	@Override
	public boolean addInstitution(InstitutionProfile institutionProfile) throws Exception {

		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		CourseCategory tempCategory  =new CourseCategory();
		CourseProfile tempCourse  =new CourseProfile();
		/*tempCourse.setInstitution(institutionProfile);
		institutionProfile.addCourseProfile(tempCourse);*/
		if(institutionProfile.getCourseCategory()!=null){
		for(CourseCategory tempCourse1:institutionProfile.getCourseCategory()){
			for(CourseProfile tempCourse11:institutionProfile.getCourseProfile()){
				tempCourse.setCourseName(tempCourse11.getCourseName());
				tempCourse.setInstitution(institutionProfile);
			}
			tempCategory.setCategoryName(tempCourse1.getCategoryName());
			tempCategory.setInstitution(institutionProfile);
			session.save(institutionProfile);
		}
		}
		
		else{
		session.save(institutionProfile);
		}
		tx.commit();
		session.close();
 		return false;
	}


	@Override
	public InstitutionProfile getInstitutionById(long id) throws Exception {
		session = sessionFactory.openSession();
		InstitutionProfile institutionProfile = (InstitutionProfile) session.load(InstitutionProfile.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return institutionProfile;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InstitutionProfile> getInstitutionList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<InstitutionProfile> institutionList = session.createCriteria(InstitutionProfile.class).list();
		tx.commit();
		session.close();
		return institutionList;
	}

	@Override
	public boolean deleteInstitution(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(InstitutionProfile.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	@Override
	public void update(long id, InstitutionProfile institutionProfile) {
		session = sessionFactory.openSession();
		InstitutionProfile institutionProfiles = (InstitutionProfile) session.byId(InstitutionProfile.class).load(id);
		institutionProfiles.setInstModifiedDateTime(institutionProfile.getInstModifiedDateTime());
		institutionProfiles.setInstAccountHolderName(institutionProfile.getInstAccountHolderName());
		institutionProfiles.setInstCourseOffered(institutionProfile.getInstCourseOffered());
		institutionProfiles.setInstAccountHolderName(institutionProfile.getInstAccountHolderName());
		institutionProfiles.setInstAccountNumber(institutionProfile.getInstAccountNumber());
		institutionProfiles.setInstAccountType(institutionProfile.getInstAccountType());
		institutionProfiles.setInstAddressone(institutionProfile.getInstAddressone());
		institutionProfiles.setInstAddresstwo(institutionProfile.getInstAddresstwo());
		institutionProfiles.setInstBankBranch(institutionProfile.getInstBankBranch());
		institutionProfiles.setInstBankName(institutionProfile.getInstBankName());
		institutionProfiles.setInstBranch(institutionProfile.getInstBranch());
		institutionProfiles.setInstCity(institutionProfile.getInstCity());
		institutionProfiles.setInstContactPerson(institutionProfile.getInstContactPerson());
		institutionProfiles.setInstCountryname(institutionProfile.getInstCountryname());
		institutionProfiles.setInstCourseCode(institutionProfile.getInstCourseCode());
		institutionProfiles.setInstCourseOffered(institutionProfile.getInstCourseOffered());
		institutionProfiles.setInstDesignation(institutionProfile.getInstDesignation());
		institutionProfiles.setInstEmail(institutionProfile.getInstEmail());
		institutionProfiles.setInstFax(institutionProfile.getInstFax());
		institutionProfiles.setInstIfscCode(institutionProfile.getInstIfscCode());
		institutionProfiles.setInstModifiedBy(institutionProfile.getInstModifiedBy());
		institutionProfiles.setInstName(institutionProfile.getInstName());
		institutionProfiles.setInstPincode(institutionProfile.getInstPincode());
		institutionProfiles.setInstRegistrationCode(institutionProfile.getInstRegistrationCode());
		institutionProfiles.setInstShortName(institutionProfile.getInstShortName());
		session.flush();
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InstitutionProfile> getCourseCategoryList1(CourseCategory courseProfile) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<InstitutionProfile> result = (List<InstitutionProfile>) session.createQuery("from InstitutionProfile ").list();
	
		 return result;
	}
	
	
	@Override
	public List<InstitutionProfile> searchInstitutionProfile(InstitutionProfile institutionProfile) throws Exception {
		session = sessionFactory.openSession();
	tx = session.beginTransaction();
	List<InstitutionProfile> institutionProfile1=null;
	
	 String hql = "SELECT b.instName as instName, b.instShortName as instShortName, b.instRegistrationCode as instRegistrationCode,b.instBranch as instBranch from InstitutionProfile b where 1=1";
	
	 if ((!StringUtils.isEmpty(institutionProfile.getInstName()))) {
	        hql = hql + (" and (b.instName = :instName) ");
	      }
	 
	 
	 if ((!StringUtils.isEmpty(institutionProfile.getInstShortName()))) {
		  hql = hql + (" and (b.instShortName = :instShortName) ");
	      }
	 
	 
	 if ((!StringUtils.isEmpty(institutionProfile.getInstRegistrationCode()))) {
		 hql = hql + (" and (b.instRegistrationCode = :instRegistrationCode) ");
	      }
	 
	 if ((!StringUtils.isEmpty(institutionProfile.getInstBranch()))) {
		 hql = hql + (" and (b.instBranch = :instBranch) ");
	      }
	
	 Query query = session.createQuery(hql);
	 
	      if ((!StringUtils.isEmpty(institutionProfile.getInstName()))) {
	        query.setString("instName", institutionProfile.getInstName());
	      }
	      if ((!StringUtils.isEmpty(institutionProfile.getInstShortName()))) {
		        query.setString("instShortName", institutionProfile.getInstShortName());
		      }
	      if ((!StringUtils.isEmpty(institutionProfile.getInstRegistrationCode()))) {
		        query.setString("instRegistrationCode", institutionProfile.getInstRegistrationCode());
		      }
	      if ((!StringUtils.isEmpty(institutionProfile.getInstBranch()))) {
		        query.setString("instBranch", institutionProfile.getInstBranch());
		      }
	      
	      query.setResultTransformer(new AliasToBeanResultTransformer(InstitutionProfile.class));
	      institutionProfile1 = query.list();
	
	return institutionProfile1;
	
	}

}
