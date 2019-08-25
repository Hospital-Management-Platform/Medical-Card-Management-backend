package com.itwine.mcm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.dao.PlanDao;
import com.itwine.mcm.model.Plan;

public class PlanServiceImpl implements PlanService{

	@Autowired
	PlanDao planDao;

	@Override
	public boolean addPlan(Plan plan) throws Exception {
		return planDao.addPlan(plan);
	}

	@Override
	public Plan getPlanById(long id) throws Exception {
		return planDao.getPlanById(id);
	}

	@Override
	public List<Plan> getPlanByList() throws Exception {
		return planDao.getPlanByList();
	}

	@Override
	public boolean deletePlan(long id) throws Exception {
		return planDao.deletePlan(id);
	}

	@Override
	public boolean updatePlan(Plan plan, long id) throws Exception {
		return planDao.updatePlan(plan, id);
	}

	
	
	
}
