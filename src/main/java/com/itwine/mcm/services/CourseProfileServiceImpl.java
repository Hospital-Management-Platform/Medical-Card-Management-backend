package com.itwine.mcm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.dao.CourseProfileDao;
import com.itwine.mcm.model.CourseCategory;
import com.itwine.mcm.model.CourseProfile;

public class CourseProfileServiceImpl implements CourseProfileService {

	@Autowired
	CourseProfileDao courseProfileDao;
	
	@Override
	public boolean addCourse(CourseProfile courseProfile) throws Exception {
		return courseProfileDao.addCourse(courseProfile);
	}

	@Override
	public CourseProfile getCourseById(long id) throws Exception {
		return courseProfileDao.getCourseById(id);
	}

	@Override
	public List<CourseProfile> getCourseByList() throws Exception {
		return courseProfileDao.getCourseByList();
	}

	@Override
	public boolean updateCourse(CourseProfile courseProfile, long id) throws Exception {
		return courseProfileDao.updateCourse(courseProfile, id);
	}

	@Override
	public boolean deleteCourse(long id) throws Exception {
		return courseProfileDao.deleteCourse(id);
	}

}
