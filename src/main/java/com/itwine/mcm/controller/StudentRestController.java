package com.itwine.mcm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itwine.mcm.model.Status;
import com.itwine.mcm.model.StudentProfile;
import com.itwine.mcm.services.StudentProfileService;

@RestController
@Controller
@RequestMapping("/students")
public class StudentRestController {

	@Autowired
	StudentProfileService studentProfileService;
	
	@Autowired
	ServletContext contex;
	
	@Autowired
	JobLauncher jobLauncher;
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addStudent(@RequestBody StudentProfile studentProfile){
		
		try{
			/*BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(studentProfile.getStdPassword());
            studentProfile.setStdPassword(encodedPassword);*/
            studentProfileService.addStudentProfile(studentProfile);
            return new Status(1, "Students inserted Successfully");
		}catch(Exception e){
			return new Status(0, e.toString());
		}		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody StudentProfile getStudentById(@PathVariable long id){
		
		StudentProfile studentProfile = null;
		try{
			studentProfile = studentProfileService.getStudentById(id);
			}catch(Exception e){
			e.printStackTrace();
		}
		return studentProfile;		
	}
	
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public @ResponseBody List<StudentProfile> getStudentList(){
		
		List<StudentProfile> studentList = null;
		try{
		 studentList = studentProfileService.getAllStudentList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return studentList;
	}
	
	@RequestMapping(value = "delete/{id}", method= RequestMethod.GET)
	public @ResponseBody Status deleteStudent(@PathVariable("id") long id){
		
		try{
		studentProfileService.deleteStudentById(id);
		return new Status(1, "Deleted Student Successfully...");
		}catch(Exception e){
			return new Status(0, e.toString());
		}
	}	
	
	@RequestMapping(value = "update/{id}", method= RequestMethod.PUT)
	public @ResponseBody Status updateStudent(@PathVariable("id") long id, @RequestBody StudentProfile studentProfile){
		
		try{
		studentProfileService.updateStudent(studentProfile,id);
		return new Status(1, "Updated Student details Successfully...");
		}catch(Exception e){
			return new Status(0, e.toString());
		}
	}	
	
	@RequestMapping(value = "/bulkuploadFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file
			) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				// Creating the directory to store file
				String rootPath = "C:/Users/Admin/Desktop/mcmwebservices/src/main/resources/cvs";
				File dir = new File(rootPath);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(
						dir.getAbsolutePath() + File.separator  + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				/*logger.info("Server File Location=" + serverFile.getAbsolutePath());
*/
				return "You successfully uploaded file=" ;
			} catch (Exception e) {
				return "You failed to upload "  + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + " because the file was empty.";
		}
	}

	@RequestMapping(value = "/startJob", method = RequestMethod.POST, produces = "application/json")
	public String startJob() throws Exception {
		String[] springConfig = { "spring/batch/config/database.xml", "spring/batch/config/context.xml",
				"spring/batch/jobs/job-report.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("reportJob");

		try {

			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");
		return "Sucessfully Added";

	}
}
