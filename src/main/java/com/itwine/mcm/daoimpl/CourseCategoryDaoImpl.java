package com.itwine.mcm.daoimpl;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.itwine.mcm.model.CourseCategory;
import com.itwine.mcm.model.CourseProfile;
import com.itwine.mcm.model.Status;
import com.itwine.mcm.dao.CourseCategoryDao;



public class CourseCategoryDaoImpl implements CourseCategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addCourseCategory(CourseCategory courseCategory) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		CourseProfile tempCourse = new CourseProfile();
		/*
		 * tempCourse.setInstitution(institutionProfile);
		 * institutionProfile.addCourseProfile(tempCourse);
		 */
		if (courseCategory.getCourseProfile() != null) {
			for (CourseProfile tempCourse1 : courseCategory.getCourseProfile()) {
				tempCourse.setCourseName(tempCourse1.getCourseName());
				tempCourse.setCourseCategory(courseCategory); 
				session.save(courseCategory);
			}
		} else{
			session.save(courseCategory);
		}
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public CourseCategory getCourseCategoryById(long id) throws Exception {
		session = sessionFactory.openSession();
		CourseCategory category = (CourseCategory) session.load(CourseCategory.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return category;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CourseCategory> getCourseCategoryList() throws Exception {
		
		
			session = sessionFactory.openSession();
		
		tx = session.beginTransaction();
		List<CourseCategory> categoryList = session.createCriteria(CourseCategory.class)
				.list();
		tx.commit();
		session.close();
		return categoryList;
		}

	@Override
	public boolean deleteCourseCategory(long id) throws Exception {
		
		try{
			session = sessionFactory.openSession();
			
		Object o = session.load(CourseCategory.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		
		return false;
		}
			catch (HibernateException e) {
				tx.rollback();
			      throw e;
			    }
	}

	@Override
	public void update(long id, CourseCategory courseCategory) {
		session = sessionFactory.openSession();
		CourseCategory courseCategorys =  (CourseCategory) session.byId(CourseCategory.class).load(id);
		courseCategorys.setModifiedDate(courseCategorys.getModifiedDate());
		courseCategorys.setCategoryCode(courseCategory.getCategoryCode());
		courseCategorys.setCategoryName(courseCategory.getCategoryName());
		courseCategorys.setStatus(courseCategory.getStatus());
	      session.flush();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CourseCategory> getCourseList2(CourseProfile courseProfile) {
		session = sessionFactory.openSession();
		List<CourseCategory> courseList=null;
		tx = session.beginTransaction();
		List<CourseCategory> result = (List<CourseCategory>) session.createQuery("from CourseCategory ").list();
	
		 return result;
	}
	
	
	@Override
	public List<CourseCategory> searchCourseCategory(CourseCategory courseCategory) throws Exception {
		
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<CourseCategory> courseCategory1=null;
		
		 String hql = "SELECT c.categoryName as categoryName, c.categoryCode as categoryCode, c.status as status from CourseCategory c where 1=1";
		
		 if ((!StringUtils.isEmpty(courseCategory.getCategoryName()))) {
		        hql = hql + (" and (c.categoryName = :categoryName) ");
		      }
		 
		 
		 if ((!StringUtils.isEmpty(courseCategory.getCategoryCode()))) {
			  hql = hql + (" and (c.categoryCode = :categoryCode) ");
		      }
		 
		 
		 if ((!StringUtils.isEmpty(courseCategory.getStatus()))) {
			 hql = hql + (" and (c.status = :status) ");
		      }
		
		 Query query = session.createQuery(hql);
		 
		      if ((!StringUtils.isEmpty(courseCategory.getCategoryName()))) {
		        query.setString("categoryName", courseCategory.getCategoryName());
		      }
		      if ((!StringUtils.isEmpty(courseCategory.getCategoryCode()))) {
			        query.setString("categoryCode", courseCategory.getCategoryCode());
			      }
		      if ((!StringUtils.isEmpty(courseCategory.getStatus()))) {
			        query.setString("status", courseCategory.getStatus());
			      }
		      
		      query.setResultTransformer(new AliasToBeanResultTransformer(CourseCategory.class));
		      courseCategory1 = query.list();
		
		return courseCategory1;
		
		}
}
