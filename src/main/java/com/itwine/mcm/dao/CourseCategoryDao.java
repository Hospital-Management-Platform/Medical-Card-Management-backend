package com.itwine.mcm.dao;

import java.util.List;

import com.itwine.mcm.model.CourseCategory;
import com.itwine.mcm.model.CourseProfile;

public interface CourseCategoryDao {
	
	public boolean addCourseCategory(CourseCategory courseCategory) throws Exception;
	public CourseCategory getCourseCategoryById(long id) throws Exception;
	public List<CourseCategory> getCourseCategoryList() throws Exception;
	public boolean deleteCourseCategory(long id) throws Exception;
	public void update(long id, CourseCategory courseCategory);
	public List<CourseCategory> getCourseList2(CourseProfile courseProfile);
	
	public List<CourseCategory> searchCourseCategory(CourseCategory courseCategory) throws Exception;

}
