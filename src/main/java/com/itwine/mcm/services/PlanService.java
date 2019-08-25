package com.itwine.mcm.services;

import java.util.List;

import com.itwine.mcm.model.Plan;

public interface PlanService {

public boolean addPlan(Plan plan) throws Exception;
	
	public Plan getPlanById(long id) throws Exception;
	
	public List<Plan> getPlanByList() throws Exception;
	
	public boolean deletePlan(long id) throws Exception;
	
	public boolean updatePlan(Plan plan, long id) throws Exception;
}
