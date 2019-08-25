package com.itwine.mcm.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.dao.AttributeDao;
import com.itwine.mcm.model.Attribute;



public class AttributeDaoImpl implements AttributeDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addAttribute(Attribute attribute) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(attribute);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Attribute getAttributeById(long id) {
		session = sessionFactory.openSession();
		Attribute attribute = (Attribute) session.load(Attribute.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return attribute;
	}

	@Override
	public List<Attribute> getAttributeList() {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Attribute> attributeList = session.createCriteria(Attribute.class).list();
		tx.commit();
		session.close();
		return attributeList;
	}

	@Override
	public boolean deleteAttribute(long id) {
		session = sessionFactory.openSession();
		Object o = session.load(Attribute.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	@Override
	public Boolean update(long id, Attribute attribute) {
		session = sessionFactory.openSession();		
		Attribute attributes = (Attribute) session.load(Attribute.class, id);
		attributes.setAttributeName(attribute.getAttributeName());
		attributes.setAttributeCode(attribute.getAttributeCode());
		attributes.setBusinessCatCode(attribute.getBusinessCatCode());
		tx= session.getTransaction();
		session.beginTransaction();
		session.update(attributes);
		tx.commit();
		session.close();
		return true;
	}

}
