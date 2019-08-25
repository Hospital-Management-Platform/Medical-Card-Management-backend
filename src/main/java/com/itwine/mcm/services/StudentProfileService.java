package com.itwine.mcm.services;

import java.util.List;

import com.itwine.mcm.model.StudentProfile;



public interface StudentProfileService {
	
	public boolean addStudentProfile(StudentProfile studentProfile) throws Exception;
	
	public StudentProfile getStudentById(long id) throws Exception;
	
	public List<StudentProfile> getAllStudentList() throws Exception;
	
	public boolean deleteStudentById(long id) throws Exception;
	
	public boolean updateStudent(StudentProfile studentProfile,long id) throws Exception;

}
