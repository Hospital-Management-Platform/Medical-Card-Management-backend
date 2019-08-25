package com.itwine.mcm.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.dao.PlansDao;
import com.itwine.mcm.model.Plans;

public class PlansServiceImpl implements PlansService{

	@Autowired
	PlansDao plansDao;
	
	@Override
	public boolean addPlans(Plans plans) throws Exception {
		return plansDao.addPlans(plans);
	}

	@Override
	public Plans getPlansById(long id) throws Exception {
		return plansDao.getPlansById(id);
	}

	@Override
	public List<Plans> getPlansByList() throws Exception {
		return plansDao.getPlansByList();
	}

	@Override
	public boolean deletePlans(long id) throws Exception {
		return plansDao.deletePlans(id);
	}

	@Override
	public boolean updatePlans(Plans plans, long id) throws Exception {
		return plansDao.updatePlans(plans, id);
	}

	@Override
	public List<Plans> getPlansCurrentList(Plans plan) {
		return plansDao.getPlansCurrentList(plan);
	}

}
