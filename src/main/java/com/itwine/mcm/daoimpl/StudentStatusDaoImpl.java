package com.itwine.mcm.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.dao.StudentStatusDao;
import com.itwine.mcm.model.StudentStatus;

public class StudentStatusDaoImpl implements StudentStatusDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;
	
	
	@Override
	public boolean addStudentStatus(StudentStatus studentStatus) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(studentStatus);
		tx.commit();
		session.close();
		return true;
	}
	@Override
	public List<StudentStatus> getStudentStatusByList() throws Exception {
		session = sessionFactory.openSession();
		tx= session.beginTransaction();
		List<StudentStatus> studentStatus = session.createCriteria(StudentStatus.class).list();
		tx.commit();
		session.close();
		return studentStatus;
	}
	
	
	

	}
