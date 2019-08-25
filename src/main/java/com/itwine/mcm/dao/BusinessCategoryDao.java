package com.itwine.mcm.dao;

import java.util.List;

import com.itwine.mcm.model.BusinessCategory;

public interface BusinessCategoryDao {

	boolean addBusinessCategory(BusinessCategory businessCategory) throws Exception;

	BusinessCategory getBusinessCategoryById(long id) throws Exception;

	List<BusinessCategory> getBusinessCategoryList() throws Exception;

	boolean deleteBusinessCategory(long id) throws Exception;

	void update(long id, BusinessCategory businessCategory);

}
