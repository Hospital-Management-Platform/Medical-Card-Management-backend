package com.itwine.mcm.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.dao.CourseOfferedDao;
import com.itwine.mcm.model.CourseOffered;

public class CourseOfferedDaoImpl implements CourseOfferedDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addCourseOffered(CourseOffered courseOffered) throws Exception {
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		session.save(courseOffered);
		tx.commit();
		session.close();		
		return true;
	}

	@Override
	public CourseOffered getCourseOfferedById(long id) throws Exception {
		session=sessionFactory.openSession();
		CourseOffered courseOffered = (CourseOffered) session.load(CourseOffered.class, id);
		tx=session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return courseOffered;
	}

	@Override
	public List<CourseOffered> getCourseOfferedByList() throws Exception {
		session=sessionFactory.openSession();
		tx=session.getTransaction();
		session.beginTransaction();
		List<CourseOffered> courseOffered = session.createCriteria(CourseOffered.class).list();
		tx.commit();
		session.close();
		return courseOffered;
	}

	@Override
	public boolean updateCourseOffered(CourseOffered courseOffered, long id) throws Exception {
		session=sessionFactory.openSession();
		CourseOffered course = (CourseOffered) session.load(CourseOffered.class, id);
		course.setCourseCode(courseOffered.getCourseCode());
		course.setStatus(courseOffered.getStatus());
		course.setModifiedBy(courseOffered.getModifiedBy());
		course.setModifiedDateTime(courseOffered.getModifiedDateTime());
		tx=session.getTransaction();
		session.beginTransaction();
		session.update(course);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteCourseOffered(long id) throws Exception {
		session=sessionFactory.openSession();
		Object o = session.load(CourseOffered.class, id);
		tx=session.beginTransaction();
		session.delete(o);
		tx.commit();
		session.close();
		return true;
	}

}
