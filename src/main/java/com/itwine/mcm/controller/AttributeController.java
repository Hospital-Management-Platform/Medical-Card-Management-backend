package com.itwine.mcm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwine.mcm.model.Attribute;
import com.itwine.mcm.model.Status;
import com.itwine.mcm.services.DataServices;

@Controller
@RequestMapping("/attribute")
public class AttributeController {

	
	@Autowired
	DataServices dataServices;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addCourseCategory(@RequestBody Attribute attribute) {
		try {
			dataServices.addAttribute(attribute);
			return new Status(1, "attribute added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Attribute getAttributeById(@PathVariable("id") long id) {
		Attribute attribute = null;
		try {
			attribute = dataServices.getAttributeById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return attribute;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Attribute> getattribute() {

		List<Attribute> attributeList = null;
		try {
			attributeList = dataServices.getAttributeList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return attributeList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteAttribute(@PathVariable("id") long id) {

		try {
			dataServices.deleteAttribute(id);
			return new Status(1, "Attribute deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status update(@RequestBody Attribute attribute ,@PathVariable("id") long id) {

		try {
			dataServices.update(id, attribute);
			return new Status(1, "Attribute updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
	

}
