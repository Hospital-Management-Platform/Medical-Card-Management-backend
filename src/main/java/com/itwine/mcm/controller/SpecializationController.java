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
import com.itwine.mcm.model.Specialization;
import com.itwine.mcm.services.DataServices;

/**
 * @author SrinivasR
 *
 */

@Controller
@RequestMapping("/specialization")
public class SpecializationController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(SpecializationController.class);

	@RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody 
	Status addSpecialization(@RequestBody Specialization specialization) {
		try {
			dataServices.addSpecialization(specialization);
			return new Status(1, "Specialization added Successfully !");
		} catch (Exception e) {
			 e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody
	Specialization getSpecializationById(@PathVariable("id") long id) {
		Specialization specialization = null;
		try {
			specialization = dataServices.getSpecializationById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return specialization;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody
	List<Specialization> deleteSpecialization() {

		List<Specialization> specializationList = null;
		try {
			specializationList = dataServices.getSpecializationList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return specializationList;
	}

	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public @ResponseBody
	Status deleteSpecialization(@PathVariable("id") long id) {

		try {
			dataServices.deleteSpecialization(id);
			return new Status(1, "Specialization deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}