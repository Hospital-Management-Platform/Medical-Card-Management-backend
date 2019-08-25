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

import com.itwine.mcm.model.BusinessCategory;
import com.itwine.mcm.services.DataServices;

/**
 * @author SrinivasR
 *
 */

@Controller
@RequestMapping("/businesscategory")
public class BusinessCategoryController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(BusinessCategoryController.class);

	@RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody 
	Status addBusinessCategory(@RequestBody BusinessCategory businessCategory) {
		try {
			dataServices.addBusinessCategory(businessCategory);
			return new Status(1, "BusinessCategory added Successfully !");
		} catch (Exception e) {
			 e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody
	BusinessCategory getBusinessCategoryById(@PathVariable("id") long id) {
		BusinessCategory businessCategory = null;
		try {
			businessCategory = dataServices.getBusinessCategoryById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return businessCategory;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody
	List<BusinessCategory> getBusinessCategoryList() {

		List<BusinessCategory> businessCategory = null;
		try {
			businessCategory = dataServices.getBusinessCategoryList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return businessCategory;
	}

	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public @ResponseBody
	Status deleteBusinessCategory(@PathVariable("id") long id) {

		try {
			dataServices.deleteBusinessCategory(id);
			return new Status(1, "BusinessCategory deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status update(@RequestBody BusinessCategory businessCategory ,@PathVariable("id") long id) {

		try {
			dataServices.update(id, businessCategory);
			return new Status(1, "BusinessCategory updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

	
}

