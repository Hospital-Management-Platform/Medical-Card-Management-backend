package com.itwine.mcm.daoimpl;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.model.BankDetails;

import com.itwine.mcm.dao.BankDetailsDao;




/**
 * @author SrinivasR
 *
 */

public class BankDetailsDaoImpl implements BankDetailsDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addBankDetails(BankDetails bankDetails) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(bankDetails);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public BankDetails getBankDetailsById(long id) throws Exception {
		session = sessionFactory.openSession();
		BankDetails details = (BankDetails) session.load(BankDetails.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return details;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BankDetails> getBankDetailsList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<BankDetails> bankDetailsList = session.createCriteria(BankDetails.class)
				.list();
		tx.commit();
		session.close();
		return bankDetailsList;
	}
	
	@Override
	public boolean deleteBankDetails(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(BankDetails.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	
}
