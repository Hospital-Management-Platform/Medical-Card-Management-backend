package com.itwine.mcm.daoimpl;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.itwine.mcm.model.Hospital;
import com.itwine.mcm.dao.HospitalDao;


/**
 * @author SrinivasR
 *
 */

public class HospitalDaoImpl implements HospitalDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addHospital(Hospital hospital) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(hospital);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Hospital getHospitalById(long id) throws Exception {
		session = sessionFactory.openSession();
		Hospital hospital = (Hospital) session.load(Hospital.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return hospital;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hospital> getHospitalList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Hospital> hospitalList = session.createCriteria(Hospital.class)
				.list();
		tx.commit();
		session.close();
		return hospitalList;
	}
	
	@Override
	public boolean deleteHospital(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Hospital.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	
}
