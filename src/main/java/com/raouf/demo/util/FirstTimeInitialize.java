package com.raouf.demo.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raouf.demo.security.AppUser;
import com.raouf.demo.security.UserService;

@Component
public class FirstTimeInitialize implements CommandLineRunner{
	
	private Log logger=LogFactory.getLog(getClass());
	
	@Autowired
	private UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("--------------------------------------------------");
		/*
		if(userService.findAll().isEmpty()) {
			System.out.println("application have users ");
			logger.info("no available users");
			AppUser user=new AppUser("raouf@gmail.com", "azerty", "raouf");
			userService.addUser(user);
		}else {
			System.out.println("no users available");
			logger.info("no available users---------------");
			AppUser user=new AppUser("raouf@gmail.com", "azerty", "raouf");
			userService.addUser(user);
		}
		*/
		
	}

}
