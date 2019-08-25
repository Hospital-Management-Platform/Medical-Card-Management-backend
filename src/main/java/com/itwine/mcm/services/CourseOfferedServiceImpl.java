package com.itwine.mcm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.dao.CourseOfferedDao;
import com.itwine.mcm.model.CourseOffered;

public class CourseOfferedServiceImpl implements CourseOfferedService{

	@Autowired
	CourseOfferedDao courseOfferedDao;
	
	@Override
	public boolean addCourseOffered(CourseOffered courseOffered) throws Exception {
		return courseOfferedDao.addCourseOffered(courseOffered);
	}

	@Override
	public CourseOffered getCourseOfferedById(long id) throws Exception {
		return courseOfferedDao.getCourseOfferedById(id);
	}

	@Override
	public List<CourseOffered> getCourseOfferedByList() throws Exception {
		return courseOfferedDao.getCourseOfferedByList();
	}

	@Override
	public boolean updateCourseOffered(CourseOffered courseOffered, long id) throws Exception {
		return courseOfferedDao.updateCourseOffered(courseOffered, id);
	}

	@Override
	public boolean deleteCourseOffered(long id) throws Exception {
		return courseOfferedDao.deleteCourseOffered(id);
	}

}
