package com.learn.spring;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void sendEmail(String mail, String rec){
		System.out.println(mail + " sent to " + rec);
	}
}
