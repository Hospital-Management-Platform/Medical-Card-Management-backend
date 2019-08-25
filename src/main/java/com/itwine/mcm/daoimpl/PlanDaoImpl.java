package com.itwine.mcm.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.dao.PlanDao;
import com.itwine.mcm.model.Plan;

public class PlanDaoImpl implements PlanDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;
	
	
	@Override
	public boolean addPlan(Plan plan) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(plan);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public Plan getPlanById(long id) throws Exception {
		session = sessionFactory.openSession();
		Plan plan = (Plan) session.load(Plan.class, id);
		tx= session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return plan;
	}

	@Override
	public List<Plan> getPlanByList() throws Exception {
		session = sessionFactory.openSession();
		tx= session.beginTransaction();
		List<Plan> plan = session.createCriteria(Plan.class).list();
		tx.commit();
		session.close();
		return plan;
	}

	@Override
	public boolean deletePlan(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Plan.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return true;
	}

	@Override
	public boolean updatePlan(Plan plan, long id) throws Exception {
		session= sessionFactory.openSession();
		Plan plan1 = (Plan) session.load(Plan.class, id);
		plan1.setPlanName(plan.getPlanName());
		plan1.setModifiedBy(plan.getModifiedBy());
		plan1.setModifiedDateTime(plan.getModifiedDateTime());
		tx= session.getTransaction();
		session.beginTransaction();
		session.update(plan1);
		tx.commit();
		session.close();
		return true;
	}

	}
