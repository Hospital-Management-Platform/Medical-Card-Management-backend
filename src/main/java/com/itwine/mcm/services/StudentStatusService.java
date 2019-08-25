package com.itwine.mcm.services;

import java.util.List;

import com.itwine.mcm.model.Plan;
import com.itwine.mcm.model.StudentStatus;

public interface StudentStatusService {

	public boolean addStudentStatus(StudentStatus studentStatus) throws Exception;
	
	public List<StudentStatus> getStudentStatusByList() throws Exception;
}
