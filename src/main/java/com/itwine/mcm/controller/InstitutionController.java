package com.itwine.mcm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwine.mcm.email.EmailTemplate;
import com.itwine.mcm.model.CourseCategory;
import com.itwine.mcm.model.CourseProfile;
import com.itwine.mcm.model.InstitutionProfile;
import com.itwine.mcm.model.Status;
import com.itwine.mcm.services.DataServices;


@RestController
@Controller
@RequestMapping("/institutions")
public class InstitutionController {

	@Autowired
	DataServices dataServices;
	// EmailService emailService;
	@Autowired
	JavaMailSender mailSenderObj;
	
	@Autowired
	 EmailController emailObj;

	static final Logger logger = Logger.getLogger(InstitutionController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addInstitution(@RequestBody InstitutionProfile institutionProfile) {
		try {
			dataServices.addInstitution(institutionProfile);
//			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//			String hashedPassword = passwordEncoder.encode(institutionProfile.getInstPassword());
//			institutionProfile.setInstPassword(hashedPassword);
            /*  EmailTemplate template = new EmailTemplate("Student.html");*/
            /*  Map<String, String> replacements = new HashMap<String, String>();
                  replacements.put("FirstName", "suneel");
                  replacements.put("Username", "suneel@itwinetech.com");
                  replacements.put("Password", "12345");
                  String message = template.getTemplate(replacements);*/
//                  mailSenderObj.prepare( "institutionCreation",template,"suneel@itwinetech.com");
			/*emailObj.sendEmailToClient("suneen", "dsdsdsd", "swamy@itwinetech.com");*/
			return new Status(1, "InstitutionProfile added Successfully !");
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody InstitutionProfile getInstitutionById(@PathVariable("id") long id) {
		InstitutionProfile institutionProfile = null;
		try {
			institutionProfile = dataServices.getInstitutionById(id);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return institutionProfile;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<InstitutionProfile> getInstitution() throws Exception   {
	List<InstitutionProfile> institutionList = null;
		try {
			institutionList = dataServices.getInstitutionList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		 

		return institutionList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Status deleteInstitution(@PathVariable("id") long id) {

		try {
			dataServices.deleteInstitution(id);
			return new Status(1, "Institution deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status update(@RequestBody InstitutionProfile institutionProfile,
			@PathVariable("id") long id) {

		try {
			dataServices.update(id, institutionProfile);
			return new Status(1, "Institution updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}
	
	@RequestMapping(value = "/institutionfetch", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getCourseCategoryList1(CourseCategory courseCategory) {

		List<InstitutionProfile> courseList = null;
		StringBuilder stringBuilder = new StringBuilder();
		try {
			courseList = dataServices.getCourseCategoryList1(courseCategory );

			stringBuilder.append("[");
			for(InstitutionProfile institutionProfile : courseList) {
				
				stringBuilder.append("{");
				stringBuilder.append("\"institutionId\":\""+institutionProfile.getInstitutionId());
				stringBuilder.append("\",\"instDesignation\":\""+institutionProfile.getInstDesignation());
				stringBuilder.append("\",\"instAddressone\":\""+institutionProfile.getInstAddressone());
				stringBuilder.append("\",\"instAddresstwo\":\""+institutionProfile.getInstAddresstwo());
				stringBuilder.append("\",\"instCity\":\""+institutionProfile.getInstCity());
				stringBuilder.append("\",\"instState\":\""+institutionProfile.getInstState());
				stringBuilder.append("\",\"instPincode\":\""+institutionProfile.getInstPincode());
				stringBuilder.append("\",\"instCountryname\":\""+institutionProfile.getInstCountryname());
				stringBuilder.append("\",\"instFax\":\""+institutionProfile.getInstFax());
				stringBuilder.append("\",\"instEmail\":\""+institutionProfile.getInstEmail());
				stringBuilder.append("\",\"InstContactPerson\":\""+institutionProfile.getInstContactPerson());
				stringBuilder.append("\",\"instCourseOffered\":\""+institutionProfile.getInstCourseOffered());
				stringBuilder.append("\",\"instStatus\":\""+institutionProfile.getInstStatus());
				stringBuilder.append("\",\"instCourseCode\":\""+institutionProfile.getInstCourseCode());
				stringBuilder.append("\",\"instMobile\":\""+institutionProfile.getInstMobile());
				stringBuilder.append("\",\"instPhone\":\""+institutionProfile.getInstPhone());
				stringBuilder.append("\",\"instCreatedBy\":\""+institutionProfile.getInstCreatedBy());
				stringBuilder.append("\",\"instCreateDateTime\":\""+institutionProfile.getInstCreateDateTime());
				stringBuilder.append("\",\"instModifiedDateTime\":\""+institutionProfile.getInstModifiedDateTime());
				stringBuilder.append("\",\"instAccountHolderName\":\""+institutionProfile.getInstAccountHolderName());
				stringBuilder.append("\",\"instAccountNumber\":\""+institutionProfile.getInstAccountNumber());
				stringBuilder.append("\",\"instIfscCode\":\""+institutionProfile.getInstIfscCode());
				stringBuilder.append("\",\"instAccountType\":\""+institutionProfile.getInstAccountType());
				stringBuilder.append("\",\"instBankName\":\""+institutionProfile.getInstBankName());
				stringBuilder.append("\",\"instName\":\""+institutionProfile.getInstName());
				stringBuilder.append("\",\"instRegistrationCode\":\""+institutionProfile.getInstRegistrationCode());
				stringBuilder.append("\",\"instBranch\":\""+institutionProfile.getInstBranch());
				stringBuilder.append("\",\"instShortName\":\""+institutionProfile.getInstShortName());
				stringBuilder.append("\",\"courseCategory\":[");
				
				
				for(CourseCategory courseCategory1 : institutionProfile.getCourseCategory()) {
					stringBuilder.append("{");
					stringBuilder.append("\"categoryId\":\""+courseCategory1.getCategoryId());
					stringBuilder.append("\",\"categoryCode\":\""+courseCategory1.getCategoryCode());
					stringBuilder.append("\",\"categoryName\":\""+courseCategory1.getCategoryName());
					stringBuilder.append("\",\"status\":\""+courseCategory1.getStatus());
					stringBuilder.append("\",\"creationDate\":\""+courseCategory1.getCreationDate());
					stringBuilder.append("\",\"createdBy\":\""+courseCategory1.getCreatedBy());
					stringBuilder.append("\"},");
				}
				if(institutionProfile.getCourseCategory().size() > 0) {
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
	public @ResponseBody List<InstitutionProfile> searchInstitutionProfile(@RequestBody InstitutionProfile institutionProfile){
		List<InstitutionProfile> institutionProfileList=null;
		try {
		institutionProfileList = dataServices.searchInstitutionProfile(institutionProfile);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return institutionProfileList;
	}

}