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


import com.itwine.mcm.model.Hospital;

import com.itwine.mcm.services.DataServices;

/**
 * @author SrinivasR
 *
 */

@Controller
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(HospitalController.class);

	@RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE/*headers={"Access-Control-Allow-Origin","*"
			,"Access-Control-Allow-Methods", "GET, POST, DELETE, PUT"}*/)
	public @ResponseBody 
	Status addHospital(@RequestBody Hospital hospital) {
		
		try {
			
			dataServices.addHospital(hospital);
			return new Status(1, "Hospital added Successfully !");
		} catch (Exception e) {
			 e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody
	Hospital getHopaitalById(@PathVariable("id") long id) {
		Hospital hospital = null;
		try {
			hospital = dataServices.getHospitalById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hospital;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody
	List<Hospital> getHospital() {

		List<Hospital> hospitalList = null;
		try {
			hospitalList = dataServices.getHospitalList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return hospitalList;
	}

	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public @ResponseBody
	Status deleteHospital(@PathVariable("id") long id) {

		try {
			dataServices.deleteHospital(id);
			return new Status(1, "Hospital deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
