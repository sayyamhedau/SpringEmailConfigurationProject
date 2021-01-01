package org.nlt.test;

import org.nlt.config.ApplicationConfig;
import org.nlt.service.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Client1 {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		EmailService emailService = context.getBean("emailService", EmailService.class);

		FileSystemResource file = new FileSystemResource("F:\\\\java programs\\\\Test.java");

		boolean emailStatus = emailService.sendEmail("abc@gmail.com", "Blog Portal",
				"You are successfully registred for Blog Portal", file);

		if (emailStatus)
			System.out.println("Email sent successfully!");
		else
			System.out.println("Failed to send email");

	
		((AnnotationConfigApplicationContext) context).close();		
	}

}
