package com.itwine.mcm.dao;

import java.util.Date;
import java.util.List;

import com.itwine.mcm.model.Plans;

public interface PlansDao {

	public boolean addPlans(Plans plans) throws Exception;
	
	public Plans getPlansById(long id) throws Exception;
	
	public List<Plans> getPlansByList() throws Exception;
	
	public boolean deletePlans(long id) throws Exception;
	
	public boolean updatePlans(Plans plans, long id) throws Exception;

	public List<Plans> getPlansCurrentList(Plans plan);
	
}
