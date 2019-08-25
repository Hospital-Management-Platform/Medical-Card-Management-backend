package com.itwine.mcm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwine.mcm.model.Plans;
import com.itwine.mcm.services.PlansService;

@RestController
@Controller
@RequestMapping(value="/plans")
public class PlansRestController {
	
	@Autowired
	PlansService plansService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addPlans(@RequestBody Plans plans){
		
		try {
		    plansService.addPlans(plans);	
		}catch(Exception e){
		return e.getMessage();
		}
		return "Plans inserted successfuly...";
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Plans getPlansById(@PathVariable long id){
		
		Plans plans=null;
		try{
		plans = plansService.getPlansById(id);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return plans;		
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody List<Plans> getPlansByList(){	
		
		List<Plans> plans=null;
		try{
		 plans = plansService.getPlansByList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return plans;
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public @ResponseBody String delete(@PathVariable long id, Plans plans){
		
		try{
		plansService.deletePlans(id);
		}catch(Exception e){
			e.getMessage();
	    }		
		return "plans deleted successfuly...";
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.PUT)
	public @ResponseBody String updatePlans(@PathVariable long id, @RequestBody Plans plans){
		
		try{
		plansService.updatePlans(plans, id);		
		}catch(Exception e){
			e.getMessage();
		}
		return "Plans Updated successfuly...";
	}
	
	@RequestMapping(value="/fetchdate", method=RequestMethod.GET)
	public @ResponseBody List<Plans> getPlansCurrentList(Plans plan){	
		
		List<Plans> plansCurrentList=null;
		try{
			plansCurrentList = plansService.getPlansCurrentList(plan);
		}catch(Exception e){
			e.printStackTrace();
		}
		return plansCurrentList;
	}
	
 }