package com.itwine.mcm.dao;

import java.util.Date;
import java.util.List;

import com.itwine.mcm.model.Plan;
import com.itwine.mcm.model.Plans;
import com.itwine.mcm.model.StudentStatus;

public interface StudentStatusDao {

public boolean addStudentStatus(StudentStatus studentStatus) throws Exception;
	
	public List<StudentStatus> getStudentStatusByList() throws Exception;
	
}
