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

import com.itwine.mcm.model.CourseCategory;
import com.itwine.mcm.model.CourseProfile;
import com.itwine.mcm.services.CourseProfileService;

@RestController
@Controller
@RequestMapping(value="/courseprofile")
public class CourseProfileRestController {

	@Autowired
	CourseProfileService courseProfileService;

	
	@RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addCourse(@RequestBody CourseProfile courseProfile){	
		try{
		courseProfileService.addCourse(courseProfile);
		}catch(Exception e){
			return e.getMessage();
		}
		return "Course added successfuly...";
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody CourseProfile getCourseById(@PathVariable long id){
		CourseProfile courseProfile=null;
		try{
			courseProfile=courseProfileService.getCourseById(id);
		}catch(Exception e){
			e.getMessage();
		}
		return courseProfile;		
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody List<CourseProfile> getCourseByList(){
		List<CourseProfile> courseProfile = null;
		try{
		courseProfile=courseProfileService.getCourseByList();
		}catch(Exception e){
			e.getMessage();
		}
		return courseProfile;
	}
	
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public @ResponseBody String deleteCourse(@PathVariable long id, CourseProfile courseProfile){
		
		try{
			courseProfileService.deleteCourse(id);
		}catch(Exception e){
			e.getMessage();
	    }		
		return "Course deleted successfuly...";
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.PUT)
	public @ResponseBody String updateCourse(@PathVariable long id, @RequestBody CourseProfile courseProfile){
		
		try{
			courseProfileService.updateCourse(courseProfile, id);		
		}catch(Exception e){
			e.getMessage();
		}
		return "Course updated successfuly...";
	}
}
