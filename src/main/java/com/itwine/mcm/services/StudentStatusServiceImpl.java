package com.itwine.mcm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.dao.PlanDao;
import com.itwine.mcm.dao.StudentStatusDao;
import com.itwine.mcm.model.Plan;
import com.itwine.mcm.model.StudentStatus;

public class StudentStatusServiceImpl implements StudentStatusService{

	@Autowired
	StudentStatusDao studentStatusDao;

	@Override
	public boolean addStudentStatus(StudentStatus studentStatus) throws Exception {
		
		return studentStatusDao.addStudentStatus(studentStatus);
	}

	@Override
	public List<StudentStatus> getStudentStatusByList() throws Exception {
		
		return studentStatusDao.getStudentStatusByList();
	}

	
}
