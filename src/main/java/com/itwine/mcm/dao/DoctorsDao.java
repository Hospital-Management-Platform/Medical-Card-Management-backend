package com.itwine.mcm.dao;

import java.util.List;

import com.itwine.mcm.model.Doctors;

public interface DoctorsDao {

	
	public boolean addDoctor(Doctors doctor) throws Exception;
	public Doctors getDoctorById(long id) throws Exception;
	public List<Doctors> getDoctorsList() throws Exception;
	public boolean deleteDoctor(long id) throws Exception;
	
}
