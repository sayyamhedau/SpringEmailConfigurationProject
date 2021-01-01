package org.nlt.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mail;

	public void setMail(JavaMailSender mail) {
		this.mail = mail;
	}

	public boolean sendEmail(String to, String subject, String message, FileSystemResource file) {
		try {
			MimeMessage mimeMessage = mail.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, file != null ? true : false);
			mimeMessageHelper.setTo("hedau555@gmail.com");
			mimeMessageHelper.setFrom("hedau555@gmail.com");
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(message);
			mimeMessageHelper.addAttachment(file.getFilename(), file);
			mail.send(mimeMessage);

			
			/*
			 * SimpleMailMessage mailMessage = new SimpleMailMessage();
			 * mailMessage.setTo(to); mailMessage.setFrom("hedau555@gmail.com");
			 * mailMessage.setSubject(subject); mailMessage.setText(message);
			 * 
			 * mail.send(mailMessage);
			 */

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
