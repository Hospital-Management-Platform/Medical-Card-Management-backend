package com.itwine.mcm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.dao.StudentProfileDao;
import com.itwine.mcm.model.StudentProfile;

public class StudentProfileServiceImpl implements StudentProfileService{

	@Autowired
	StudentProfileDao studentProfileDao;
	
	@Override
	public boolean addStudentProfile(StudentProfile studentProfile) throws Exception {		
		return studentProfileDao.addStudent(studentProfile);
	}

	@Override
	public StudentProfile getStudentById(long id) throws Exception {		
		return studentProfileDao.getStudentById(id);
	}

	@Override
	public boolean deleteStudentById(long id) throws Exception {		
		return studentProfileDao.deleteStudentById(id);
	}

	@Override
	public List<StudentProfile> getAllStudentList() throws Exception {	
		return studentProfileDao.getStudentProfileByList();
	}

	@Override
	public boolean updateStudent(StudentProfile studentProfile, long id) throws Exception {		
		return studentProfileDao.updateStudent(studentProfile,id);
	}

}
