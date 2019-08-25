package com.itwine.mcm.dao;

import java.util.List;

import com.itwine.mcm.model.StudentProfile;

public interface StudentProfileDao {
	
	public boolean	addStudent(StudentProfile studentProfile) throws Exception;
	
	public StudentProfile getStudentById(long id) throws Exception;
	
	public List<StudentProfile> getStudentProfileByList() throws Exception;
	
	public boolean deleteStudentById(long id) throws Exception;
	
	public boolean updateStudent(StudentProfile studentProfile, long id) throws Exception;

}
