package com.learn.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learn.spring.config.AppConfig;

public class MainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		HelloSpring hello = context.getBean(HelloSpring.class);

		hello.processMail("Hi this test email", "some-email-address");
	}

}
