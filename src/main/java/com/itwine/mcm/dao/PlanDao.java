package com.itwine.mcm.dao;

import java.util.Date;
import java.util.List;

import com.itwine.mcm.model.Plan;
import com.itwine.mcm.model.Plans;

public interface PlanDao {

	public boolean addPlan(Plan plan) throws Exception;
	
	public Plan getPlanById(long id) throws Exception;
	
	public List<Plan> getPlanByList() throws Exception;
	
	public boolean deletePlan(long id) throws Exception;
	
	public boolean updatePlan(Plan plan, long id) throws Exception;
	
}
