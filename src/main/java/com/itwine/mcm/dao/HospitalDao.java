package com.itwine.mcm.dao;

import java.util.List;

import com.itwine.mcm.model.Hospital;

public interface HospitalDao {
	
	
	public boolean addHospital(Hospital hospital) throws Exception;
	public Hospital getHospitalById(long id) throws Exception;
	public List<Hospital> getHospitalList() throws Exception;
	public boolean deleteHospital(long id) throws Exception;

}
