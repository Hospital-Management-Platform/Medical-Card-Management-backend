package com.itwine.mcm.dao;

import java.util.List;

import com.itwine.mcm.model.Attribute;


public interface AttributeDao {

	public boolean addAttribute(Attribute attribute) ;

	public Attribute getAttributeById(long id) ;

	public List<Attribute> getAttributeList() ;
	
	public boolean deleteAttribute(long id) ;
		
	public Boolean update(long id, Attribute attribute) ;
	
	
	
	
}
