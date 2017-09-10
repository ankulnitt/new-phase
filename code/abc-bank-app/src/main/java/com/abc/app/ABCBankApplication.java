package com.abc.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.abc.service.Consumer;
import com.abc.service.CustomerService;
import com.abc.service.TokenService;
import com.abc.token.TokenGenertor;

/**
 * 
 * @author ankul1874
 * @Purpose This class is entry point of application. It'll start token generator thread.
 */
@SpringBootApplication
@ComponentScan({ "com.abc.*" })
@EntityScan("com.abc.model")
public class ABCBankApplication implements CommandLineRunner {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired 
	private Consumer consumer;

	public static void main(String[] args) throws Exception {

		SpringApplication app = new SpringApplication(ABCBankApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		TokenGenertor tokenGenertor = new TokenGenertor(customerService, tokenService, consumer);
		new Thread(tokenGenertor).start();
	}
}