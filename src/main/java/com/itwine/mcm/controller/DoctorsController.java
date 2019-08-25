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
import com.itwine.mcm.model.Doctors;
import com.itwine.mcm.services.DataServices;

/**
 * @author SrinivasR
 *
 */

@Controller
@RequestMapping("/doctor")
public class DoctorsController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(DoctorsController.class);

	@RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody 
	Status addDoctor(@RequestBody Doctors doctor) {
		try {
			dataServices.addDoctor(doctor);
			return new Status(1, "Doctor added Successfully !");
		} catch (Exception e) {
			 e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody
	Doctors getDoctorById(@PathVariable("id") long id) {
		Doctors doctor = null;
		try {
			doctor = dataServices.getDoctorById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctor;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody
	List<Doctors> deleteDoctor() {

		List<Doctors> doctorsList = null;
		try {
			doctorsList = dataServices.getDoctorsList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return doctorsList;
	}

	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public @ResponseBody
	Status deleteHospital(@PathVariable("id") long id) {

		try {
			dataServices.deleteDoctor(id);
			return new Status(1, "Doctors deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}