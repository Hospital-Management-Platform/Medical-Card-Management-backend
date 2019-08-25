package com.itwine.mcm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.dao.MembershipDao;
import com.itwine.mcm.model.Membership;

public class MembershipServiceImpl implements MembershipService{

	@Autowired
	MembershipDao membershipDao;
	
	@Override
	public boolean addMembership(Membership membership) throws Exception {
		return membershipDao.addMembership(membership);
	}

	@Override
	public Membership getMembershipById(long id) throws Exception {
		return membershipDao.getMembershipById(id);
	}

	@Override
	public List<Membership> getMembershipByList() throws Exception {
		return membershipDao.getMembershipByList();
	}

	@Override
	public boolean updateMembership(Membership membership, long id) throws Exception {
		return membershipDao.updateMembership(membership, id);
	}

	@Override
	public boolean deleteMembership(long id) throws Exception {
		return membershipDao.deleteMembership(id);
	}

}
