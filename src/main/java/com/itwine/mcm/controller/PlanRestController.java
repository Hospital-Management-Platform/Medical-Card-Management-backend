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
import org.springframework.web.bind.annotation.RestController;

import com.itwine.mcm.model.Plan;
import com.itwine.mcm.services.PlanService;

@RestController
@Controller
@RequestMapping(value="/plan")
public class PlanRestController {
	
	@Autowired
	PlanService planService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addPlan(@RequestBody Plan plan){
		
		try {
			planService.addPlan(plan);	
		}catch(Exception e){
		return e.getMessage();
		}
		return "Plan inserted successfuly...";
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Plan getPlanById(@PathVariable long id){
		
		Plan plan=null;
		try{
		plan = planService.getPlanById(id);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return plan;		
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody List<Plan> getPlansByList(){	
		
		List<Plan> plan=null;
		try{
		 plan = planService.getPlanByList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return plan;
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public @ResponseBody String delete(@PathVariable long id, Plan plan){
		
		try{
			planService.deletePlan(id);
		}catch(Exception e){
			e.getMessage();
	    }		
		return "plan deleted successfuly...";
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.PUT)
	public @ResponseBody String updatePlan(@PathVariable long id, @RequestBody Plan plan){
		
		try{
			planService.updatePlan(plan, id);		
		}catch(Exception e){
			e.getMessage();
		}
		return "Plan Updated successfuly...";
	}
	
 }