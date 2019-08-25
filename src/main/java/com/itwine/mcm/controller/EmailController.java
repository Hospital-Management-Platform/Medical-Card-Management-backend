package com.itwine.mcm.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itwine.mcm.model.InstitutionProfile;

@Controller
public class EmailController {

	static String emailToRecipient, emailSubject, emailMessage;
	static final String emailFromRecipient = "mvmohan19@gmail.com";

	static ModelAndView modelViewObj;

	@Autowired
	private JavaMailSender mailSenderObj;
   

	@RequestMapping(value = {"/emailForm"}, method = RequestMethod.GET)
	public ModelAndView showEmailForm(ModelMap model) {
		modelViewObj = new ModelAndView("emailForm");
		return  modelViewObj;		
	}

	// This Method Is Used To Prepare The Email Message And Send It To The Client
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public ModelAndView sendEmailToClient(@RequestParam("emailSubject") String emailSubject,@RequestParam("emailMessage") String emailMessage,@RequestParam("emailToRecipient") String emailToRecipient) {

//		InstitutionProfile institution = new InstitutionProfile();
//		String Filename = request.getParameter(institution.getInstEmail());
//		// Reading Email Form Input Parameters		
//		emailSubject = request.getParameter("subject");
//		emailMessage = request.getParameter("message");
//		emailToRecipient = request.getParameter(Filename);

		// Logging The Email Form Parameters For Debugging Purpose
		System.out.println("\nReceipient?= " + emailToRecipient + ", Subject?= " + emailSubject + ", Message?= " + emailMessage + "\n");

		
		mailSenderObj.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");				
				mimeMsgHelperObj.setTo(emailToRecipient);
				mimeMsgHelperObj.setFrom(emailFromRecipient);				
				mimeMsgHelperObj.setText(emailMessage);
				mimeMsgHelperObj.setSubject(emailSubject);

				// Determine If There Is An File Upload. If Yes, Attach It To The Client Email				
//				if ((attachFileObj != null) && (attachFileObj.getSize() > 0) && (!attachFileObj.equals(""))) {
//					System.out.println("\nAttachment Name?= " + attachFileObj.getOriginalFilename() + "\n");
//					mimeMsgHelperObj.addAttachment(attachFileObj.getOriginalFilename(), new InputStreamSource() {					
//						public InputStream getInputStream() throws IOException {
//							return attachFileObj.getInputStream();
//						}
//					});
				}  {
					System.out.println("\nNo Attachment Is Selected By The User. Sending Text Email!\n");
				}
			
		});
		System.out.println("\nMessage Send Successfully.... Hurrey!\n");

		modelViewObj = new ModelAndView("success","messageObj","Thank You! Your Email Has Been Sent!");
		return  modelViewObj;	
	}
}