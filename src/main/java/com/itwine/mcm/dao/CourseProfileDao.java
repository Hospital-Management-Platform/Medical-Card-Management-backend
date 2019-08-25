package com.itwine.mcm.dao;

import java.util.List;

import com.itwine.mcm.model.CourseCategory;
import com.itwine.mcm.model.CourseProfile;

public interface CourseProfileDao {

	public boolean addCourse(CourseProfile courseProfile) throws Exception;
	
	public CourseProfile getCourseById(long id) throws Exception;
	
	public List<CourseProfile> getCourseByList() throws Exception;	
	
	public boolean updateCourse(CourseProfile courseProfile, long id) throws Exception;
	
	public boolean deleteCourse(long id) throws Exception;
}
