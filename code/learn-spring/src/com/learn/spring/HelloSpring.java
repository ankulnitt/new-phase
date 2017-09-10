package com.learn.spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloSpring {
	@Autowired
	private EmailService emailService;
	
//	public HelloSpring(){}
//
//	@Autowired 
//	public HelloSpring(EmailService emailService) {
//		this.emailService = emailService;
//	}

	
	public void processMail(String message, String rec) {
		emailService.sendEmail(message, rec);
	}
	
	@Resource
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
}
