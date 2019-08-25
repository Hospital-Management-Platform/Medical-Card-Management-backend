package com.itwine.mcm.services;

import java.util.List;

import com.itwine.mcm.model.CourseOffered;

public interface CourseOfferedService {

	public boolean addCourseOffered(CourseOffered courseOffered) throws Exception;

	public CourseOffered getCourseOfferedById(long id) throws Exception;

	public List<CourseOffered> getCourseOfferedByList() throws Exception;	

	public boolean updateCourseOffered(CourseOffered courseOffered, long id) throws Exception;

	public boolean deleteCourseOffered(long id) throws Exception;
	
}
