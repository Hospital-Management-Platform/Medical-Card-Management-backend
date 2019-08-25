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
import com.itwine.mcm.model.CourseOffered;
import com.itwine.mcm.services.CourseOfferedService;


@RestController
@Controller
@RequestMapping(value="/courseoffered")
public class CourseOfferedRestController {

	@Autowired
	CourseOfferedService courseOfferedService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addCourseOffered(@RequestBody CourseOffered courseOffered){	
		try{
			courseOfferedService.addCourseOffered(courseOffered);
		}catch(Exception e){
			return e.getMessage();
		}
		return "Course Offered added successfuly...";
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody CourseOffered getCourseOfferedById(@PathVariable long id){
		CourseOffered courseOffered=null;
		try{
			courseOffered=courseOfferedService.getCourseOfferedById(id);
		}catch(Exception e){
			e.getMessage();
		}
		return courseOffered;		
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody List<CourseOffered> getCourseOfferedByList(){
		List<CourseOffered> courseOffered = null;
		try{
			courseOffered=courseOfferedService.getCourseOfferedByList();
		}catch(Exception e){
			e.getMessage();
		}
		return courseOffered;
	}
	
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public @ResponseBody String deleteCourseOffered(@PathVariable long id, CourseOffered courseOffered){
		
		try{
			courseOfferedService.deleteCourseOffered(id);
		}catch(Exception e){
			e.getMessage();
	    }		
		return "CourseOffered deleted successfuly...";
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.PUT)
	public @ResponseBody String updateCourseOffered(@PathVariable long id, @RequestBody CourseOffered courseOffered){
		
		try{
			courseOfferedService.updateCourseOffered(courseOffered, id);		
		}catch(Exception e){
			e.getMessage();
		}
		return "CourseOffered updated successfuly...";
	}
}
