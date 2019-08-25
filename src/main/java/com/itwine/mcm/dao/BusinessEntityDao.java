package com.itwine.mcm.dao;

import java.util.List;

import com.itwine.mcm.model.BusinessEntity;
 

public interface BusinessEntityDao {

	public BusinessEntity getBusinessEntityById(long id) throws Exception;
	public List<BusinessEntity> getBusinessEntityList() throws Exception;
	public boolean deleteBusinessEntity(long id) throws Exception;
	boolean addBusinessEntity(BusinessEntity businessEntity) throws Exception;
	/*public Boolean findEmail(String businessEmail);*/
	public void update(long id, BusinessEntity BusinessEntity);
	
}