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
import com.itwine.mcm.model.CourseCategory;
import com.itwine.mcm.model.CourseProfile;
import com.itwine.mcm.services.DataServices;

/**
 * @author SrinivasR
 *
 */

@Controller
@RequestMapping("/coursecategory")
public class CourseCategoryController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(CourseCategoryController.class);

	@RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody 
	Status addCourseCategory(@RequestBody CourseCategory courseCategory) {
		try {
			dataServices.addCourseCategory(courseCategory);
			return new Status(1, "CoursesCategory added Successfully !");
		} catch (Exception e) {
			 e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody
	CourseCategory getCourseCategoryById(@PathVariable("id") long id) {
		CourseCategory courseCategory = null;
		try {
			courseCategory = dataServices.getCourseCategoryById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseCategory;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody
	List<CourseCategory> getCourseCategoryList() {

		List<CourseCategory> categoryList = null;
		try {
			categoryList = dataServices.getCourseCategoryList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoryList;
	}

	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public @ResponseBody
	Status deleteCourseCategory(@PathVariable("id") long id) {

		try {
			dataServices.deleteCourseCategory(id);
			return new Status(1, "Category deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status update(@RequestBody CourseCategory courseCategory ,@PathVariable("id") long id) {

		try {
			dataServices.update(id, courseCategory);
			return new Status(1, "Category updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getCourseList2(CourseProfile courseProfile) {

		List<CourseCategory> courseList = null;
		StringBuilder stringBuilder = new StringBuilder();
		try {
			courseList = dataServices.getCourseList2(courseProfile );

			stringBuilder.append("[");
			for(CourseCategory courseCategory : courseList) {
				
				stringBuilder.append("{");
				stringBuilder.append("\"categoryId\":\""+courseCategory.getCategoryId());
				stringBuilder.append("\",\"categoryCode\":\""+courseCategory.getCategoryCode());
				stringBuilder.append("\",\"categoryName\":\""+courseCategory.getCategoryName());
				stringBuilder.append("\",\"status\":\""+courseCategory.getStatus());
				stringBuilder.append("\",\"creationDate\":\""+courseCategory.getCreationDate());
				stringBuilder.append("\",\"createdBy\":\""+courseCategory.getCreatedBy());
				stringBuilder.append("\",\"courseProfile\":[");
				
				
				for(CourseProfile coursePro : courseCategory.getCourseProfile()) {
					stringBuilder.append("{");
					stringBuilder.append("\"courseId\":\""+coursePro.getCourseId());
					stringBuilder.append("\",\"courseName\":\""+coursePro.getCourseName());
					stringBuilder.append("\",\"courseCode\":\""+coursePro.getCourseCode());
					stringBuilder.append("\",\"duration\":\""+coursePro.getDuration());
					stringBuilder.append("\"},");
				}
				if(courseCategory.getCourseProfile().size() > 0) {
					stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.length() - 1));
				}
				stringBuilder.append("]},");
			}
			stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.length() - 1));
			stringBuilder.append("]");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	
	@RequestMapping(value="/searchList", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CourseCategory> searchPlans(@RequestBody CourseCategory courseCategory){
		List<CourseCategory> courseCategoryList=null;
		try {
			courseCategoryList = dataServices.searchCourseCategory(courseCategory);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return courseCategoryList;
	}

	
}

