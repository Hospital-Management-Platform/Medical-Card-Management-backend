package com.itwine.mcm.dao;

import java.util.List;

import com.itwine.mcm.model.Specialization;

public interface SpecializationDao {

	public boolean addSpecialization(Specialization specialization) throws Exception;
	public Specialization getSpecializationById(long id) throws Exception;
	public List<Specialization> getSpecializationList() throws Exception;
	public boolean deleteSpecialization(long id) throws Exception;
	
	
}
