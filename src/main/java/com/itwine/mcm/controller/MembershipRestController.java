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

import com.itwine.mcm.model.Membership;
import com.itwine.mcm.services.MembershipService;

@RestController
@Controller
@RequestMapping(value="/membership")
public class MembershipRestController {

	@Autowired
	MembershipService membershipService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addMembership(@RequestBody Membership membership){	
		try{
			membershipService.addMembership(membership);
		}catch(Exception e){
			return e.getMessage();
		}
		return "Membership added successfuly...";
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Membership getMembershipById(@PathVariable long id){
		Membership membership=null;
		try{
			membership=membershipService.getMembershipById(id);
		}catch(Exception e){
			e.getMessage();
		}
		return membership;		
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody List<Membership> getMembershipByList(){
		List<Membership> membership = null;
		try{
			membership=membershipService.getMembershipByList();
		}catch(Exception e){
			e.getMessage();
		}
		return membership;
	}
	
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public @ResponseBody String deleteMembership(@PathVariable long id, Membership membership){
		
		try{
			membershipService.deleteMembership(id);
		}catch(Exception e){
			e.getMessage();
	    }		
		return "Membership deleted successfuly...";
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.PUT)
	public @ResponseBody String updateCourse(@PathVariable long id, @RequestBody Membership membership){
		
		try{
			membershipService.updateMembership(membership, id);		
		}catch(Exception e){
			e.getMessage();
		}
		return "Membership updated successfuly...";
	}
}
