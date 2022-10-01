package com.raouf.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WelcomeController {
	
	@GetMapping("/{name}")
	public String welcome(@PathVariable String name) {
		return "welcome to spring boot "+name;
	}
}
