package com.itwine.mcm.daoimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.dao.PlansDao;
import com.itwine.mcm.model.Plans;

public class PlansDaoImpl implements PlansDao{

	

	@Autowired
	SessionFactory sessionFactory;
	
	Session session= null;
	Transaction tx= null;
	
	

	public static final Calendar beforeFirstCalendar;
	static {
	    beforeFirstCalendar = GregorianCalendar.getInstance();
	    beforeFirstCalendar.set(2099, 1, 1, 0, 0, 1);
	}
	public static Date beforeFirstDate = beforeFirstCalendar.getTime();
	
	
	
	@Override
	public boolean addPlans(Plans plans) throws Exception {
		
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		if (plans.getPlanMembership().equals("Annual") && plans.getPlanName().equals("Gold")
				|| plans.getPlanMembership().equals("Monthly") && plans.getPlanName().equals("Silver")
				|| plans.getPlanMembership().equals("Annual") && plans.getPlanName().equals("Silver")
				|| plans.getPlanMembership().equals("Annual") && plans.getPlanName().equals("Platinum")
				|| plans.getPlanMembership().equals("Monthly") && plans.getPlanName().equals("Gold")
				|| plans.getPlanMembership().equals("Monthly") && plans.getPlanName().equals("Platinum")) {

			List<Plans> pl = session.createCriteria(Plans.class).list();
			Plans lastValue = pl.get(pl.size() - 1);
			Calendar cal = Calendar.getInstance();
			Date date2 = lastValue.getStartDateTime();
			Date date1 = plans.getStartDateTime();
			cal.setTime(date1);
			cal.setTime(date2);
			int daysToDecrement1 = -1;
			cal.add(Calendar.DATE, daysToDecrement1);
			date1 = cal.getTime();
			if (date2 == date1) {

				throw new Exception("dates are same ");
			}
			lastValue.setEndDateTime(date1);

			plans.setEndDateTime(beforeFirstDate);
			session.save(plans);

		} else {
			plans.setEndDateTime(beforeFirstDate);
			session.save(plans);
		}
		tx.commit();
		session.close();
		return true;
		
	}
	@Override
	public Plans getPlansById(long id) throws Exception {
		session = sessionFactory.openSession();
		Plans plan = (Plans) session.load(Plans.class, id);
		tx=session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return plan;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Plans> getPlansByList() throws Exception {
		session = sessionFactory.openSession();
		tx= session.getTransaction();
		session.beginTransaction();
		List<Plans> plan= session.createCriteria(Plans.class).list();
		tx.commit();
		session.close();
		return plan;
	}

	@Override
	public boolean deletePlans(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o= session.load(Plans.class, id);
		tx=session.beginTransaction();
		session.delete(o);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean updatePlans(Plans plans, long id) throws Exception {		
		session = sessionFactory.openSession();		
	    Plans plan = (Plans) session.load(Plans.class, id);
		plan.setPlanName(plans.getPlanName());
		plan.setPlanPrice(plans.getPlanPrice());
		plan.setPlanMembership(plans.getPlanMembership());
	     if(plans.getPlanMembership().equals("ANNUAL"));
		{
			List<Plans> pl= session.createCriteria(Plans.class).list();
			Plans lastValue = pl.get(pl.size()-1);	
			lastValue.setEndDateTime(plans.getStartDateTime());
		}
		tx= session.getTransaction();
		session.beginTransaction();
		session.update(plan);
		tx.commit();
		session.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Plans> getPlansCurrentList(Plans plan) {
		session = sessionFactory.openSession();
		List<Plans> plansCurrentList= null;
		tx= session.getTransaction();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Query query = session.createQuery("SELECT p.planName, p.planPrice, p.planMembership from Plans p where p.startDateTime = :date" );
		query.setDate("date",date);
		plansCurrentList = query.list();	
		return plansCurrentList;
			
	}
	

}
