package com.itwine.mcm.daoimpl;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.itwine.mcm.model.BusinessEntity;
import com.itwine.mcm.dao.BusinessEntityDao;



/**
 * @author SrinivasR
 *
 */

public class BusinessEntityDaoImpl implements BusinessEntityDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addBusinessEntity(BusinessEntity businessEntity) throws Exception {

		/*if(findEmail(businessEntity.getBusinessEmail())) {
			   throw new EmailExistsException( "There is an account with that email adress:" +businessEntity.getBusinessEmail());
			}*/
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(businessEntity);
		tx.commit();
		session.close();
		
		return false;
	}

	@Override
	public BusinessEntity getBusinessEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		BusinessEntity businessEntity = (BusinessEntity) session.load(BusinessEntity.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return businessEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusinessEntity> getBusinessEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<BusinessEntity> businessEntity = session.createCriteria(BusinessEntity.class)
				.list();
		tx.commit();
		session.close();
		return businessEntity;
	}
	
	@Override
	public boolean deleteBusinessEntity(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(BusinessEntity.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	
	/*@Override
	public Boolean findEmail(String businessEmail) {
		session = sessionFactory.openSession();
		List<BusinessEntity> businessEntityList = session.createCriteria(BusinessEntity.class).list();
		session.close();
		for (BusinessEntity entity: businessEntityList) {
            if (entity.getBusinessEmail().equals(businessEmail)) {
       return true;
   }
}
return false;
}*/

	@Override
	public void update(long id, BusinessEntity BusinessEntity) {
		session = sessionFactory.openSession();
		BusinessEntity entity =  (BusinessEntity) session.byId(BusinessEntity.class).load(id);
		
		entity.setName(BusinessEntity.getName());
		entity.setRegistrationCode(BusinessEntity.getRegistrationCode());
		entity.setAccountHolderName(BusinessEntity.getAccountHolderName());
		entity.setAccountNumber(BusinessEntity.getAccountNumber());
		entity.setAddress1(BusinessEntity.getAddress1());
		entity.setAddress2(BusinessEntity.getAddress2());
		entity.setBankName(BusinessEntity.getBankName());
		entity.setCity(BusinessEntity.getCity());
		entity.setState(BusinessEntity.getState());
		entity.setContactPerson(BusinessEntity.getContactPerson());
		entity.setShortname(BusinessEntity.getShortname());
		entity.setBankBranch(BusinessEntity.getBankBranch());
		entity.setPhone(BusinessEntity.getPhone());
		entity.setCountry(BusinessEntity.getCountry());
		entity.setPincode(BusinessEntity.getPincode());
		entity.setIfscCode(BusinessEntity.getIfscCode());
		entity.setDesignation(BusinessEntity.getDesignation());
		entity.setBusinessCategoryCode(BusinessEntity.getBusinessCategoryCode());
		entity.setAccountType(BusinessEntity.getAccountType());
		entity.setMobile(BusinessEntity.getMobile());
		 session.flush();
		
	}
	
	
}
