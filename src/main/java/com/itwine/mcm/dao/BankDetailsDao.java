package com.itwine.mcm.dao;

import java.util.List;

import com.itwine.mcm.model.BankDetails;

public interface BankDetailsDao {

	boolean addBankDetails(BankDetails bankDetails) throws Exception;

	BankDetails getBankDetailsById(long id) throws Exception;

	List<BankDetails> getBankDetailsList() throws Exception;

	boolean deleteBankDetails(long id) throws Exception;

}
