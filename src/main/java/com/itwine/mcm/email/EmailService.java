/*package com.itwine.mcm.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Service
public class EmailService {
	
	@Autowired
	private  JavaMailSender mailSender;

	static final Logger logger = Logger.getLogger(EmailService.class);
	
	public  void send(Email eParams) {

			try {
				sendHtmlMail(eParams);
			} catch (MessagingException e) {
				logger.error("Could not send email to : {} Error = {}"+ eParams.getToAsList()+ e.getMessage());
			}
		

	}

	private  void sendHtmlMail(Email eParams) throws MessagingException {

		boolean isHtml = true;

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(eParams.getTo().toArray(new String[eParams.getTo().size()]));
		helper.setReplyTo(eParams.getFrom());
		helper.setFrom(eParams.getFrom());
		helper.setSubject(eParams.getSubject());
		helper.setText(eParams.getMessage(), isHtml);

		if (eParams.getCc().size() > 0) {
			helper.setCc(eParams.getCc().toArray(new String[eParams.getCc().size()]));
		}

		mailSender.send(message);
	}

}
*/



