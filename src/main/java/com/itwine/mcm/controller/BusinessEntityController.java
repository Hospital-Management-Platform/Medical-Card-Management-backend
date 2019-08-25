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
import com.itwine.mcm.model.BusinessEntity;
import com.itwine.mcm.services.DataServices;

/**
 * @author SrinivasR
 *
 */

@Controller
@RequestMapping("/businessentity")
public class BusinessEntityController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(BusinessEntityController.class);

	@RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody 
	Status addBusinessEntity(@RequestBody BusinessEntity businessEntity) {
		try {
			dataServices.addBusinessEntity(businessEntity);
			return new Status(1, "BusinessEntity added Successfully !");
		} catch (Exception e) {
			 e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody
	BusinessEntity getBusinessEntityById(@PathVariable("id") long id) {
		BusinessEntity businessEntity = null;
		try {
			businessEntity = (BusinessEntity) dataServices.getBusinessEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return businessEntity;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody
	List<BusinessEntity> getBusinessEntityList() {

		List<BusinessEntity> businessEntity = null;
		try {
			businessEntity = dataServices.getBusinessEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return businessEntity;
	}

	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public @ResponseBody
	Status deleteBusinessEntity(@PathVariable("id") long id) {

		try {
			dataServices.deleteBusinessEntity(id);
			return new Status(1, "BusinessEntity deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status update(@RequestBody BusinessEntity BusinessEntity ,@PathVariable("id") long id) {

		try {
			dataServices.update(id, BusinessEntity);
			return new Status(1, "BusinessEntity updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
	
	
}
