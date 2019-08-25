package com.itwine.mcm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwine.mcm.model.StudentStatus;
import com.itwine.mcm.services.StudentStatusService;

@RestController
@Controller
@RequestMapping(value="/studentStatus")
public class StudentStatusRestController {
	
	@Autowired
	StudentStatusService studentStatusService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addStudentStatus(@RequestBody StudentStatus studentStatus){
		
		try {
			studentStatusService.addStudentStatus(studentStatus);
		}catch(Exception e){
		return e.getMessage();
		}
		return "StudentStatus inserted successfuly...";
    }
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody List<StudentStatus> getStudentStatusByList(){	
		
		List<StudentStatus> studentStatus=null;
		try{
			studentStatus = studentStatusService.getStudentStatusByList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return studentStatus;
	}
	
 }