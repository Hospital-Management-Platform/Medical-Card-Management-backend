package com.itwine.mcm.daoimpl;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.itwine.mcm.model.Doctors;
import com.itwine.mcm.dao.DoctorsDao;



/**
 * @author SrinivasR
 *
 */

public class DoctorsDaoImpl implements DoctorsDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addDoctor(Doctors doctor) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(doctor);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Doctors getDoctorById(long id) throws Exception {
		session = sessionFactory.openSession();
		Doctors doctor = (Doctors) session.load(Doctors.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return doctor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctors> getDoctorsList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Doctors> doctorsList = session.createCriteria(Doctors.class)
				.list();
		tx.commit();
		session.close();
		return doctorsList;
	}
	
	@Override
	public boolean deleteDoctor(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Doctors.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	
}
