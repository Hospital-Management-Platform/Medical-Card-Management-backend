package com.itwine.mcm.dao;

import java.util.List;

import com.itwine.mcm.model.Membership;

public interface MembershipDao {
	
	public boolean addMembership(Membership membership) throws Exception;
	
	public Membership getMembershipById(long id) throws Exception;
	
	public List<Membership> getMembershipByList() throws Exception;	
	
	public boolean updateMembership(Membership membership, long id) throws Exception;
	
	public boolean deleteMembership(long id) throws Exception;
}