package com.itwine.mcm.controller;

import java.util.List;

import org.apache.log4j.Logger;
import com.itwine.mcm.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwine.mcm.model.BankDetails;

import com.itwine.mcm.services.DataServices;

/**
 * @author SrinivasR
 *
 */

@Controller
@RequestMapping("/bankdetails")
public class BankDetailsController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(BankDetailsController.class);

	@RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody 
	Status addBankDetails(@RequestBody BankDetails bankDetails) {
		try {
			dataServices.addBankDetails(bankDetails);
			return new Status(1, "BankDetails added Successfully !");
		} catch (Exception e) {
			 e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody
	BankDetails getBankDetailsById(@PathVariable("id") long id) {
		BankDetails bankDetails = null;
		try {
			bankDetails = dataServices.getBankDetailsById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankDetails;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody
	List<BankDetails> getBankDetailsList() {

		List<BankDetails> bankDetailsList = null;
		try {
			bankDetailsList = dataServices.getBankDetailsList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bankDetailsList;
	}

	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public @ResponseBody
	Status deleteBankDetails(@PathVariable("id") long id) {

		try {
			dataServices.deleteBankDetails(id);
			return new Status(1, "BankDetails deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}