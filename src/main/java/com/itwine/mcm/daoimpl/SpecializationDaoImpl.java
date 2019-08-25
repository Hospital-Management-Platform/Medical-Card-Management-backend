package com.itwine.mcm.daoimpl;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.itwine.mcm.model.Doctors;
import com.itwine.mcm.model.Specialization;
import com.itwine.mcm.dao.SpecializationDao;



/**
 * @author SrinivasR
 *
 */

public class SpecializationDaoImpl implements SpecializationDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addSpecialization(Specialization specialization) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(specialization);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Specialization getSpecializationById(long id) throws Exception {
		session = sessionFactory.openSession();
		Specialization specialization = (Specialization) session.load(Specialization.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return specialization;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Specialization> getSpecializationList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Specialization> specializationList = session.createCriteria(Specialization.class)
				.list();
		tx.commit();
		session.close();
		return specializationList;
	}
	
	@Override
	public boolean deleteSpecialization(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Doctors.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	
}
