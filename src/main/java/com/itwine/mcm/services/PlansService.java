package com.itwine.mcm.services;

import java.util.Date;
import java.util.List;

import com.itwine.mcm.model.Plans;

public interface PlansService {

public boolean addPlans(Plans plans) throws Exception;
	
	public Plans getPlansById(long id) throws Exception;
	
	public List<Plans> getPlansByList() throws Exception;
	
	public boolean deletePlans(long id) throws Exception;
	
	public boolean updatePlans(Plans plans, long id) throws Exception;
	
	/*Date date=new Date();*/
	public List<Plans> getPlansCurrentList(Plans plan);
}
