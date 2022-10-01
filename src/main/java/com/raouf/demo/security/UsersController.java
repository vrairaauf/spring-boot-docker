package com.raouf.demo.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raouf.demo.ToDo;

@RestController
@RequestMapping("/todo/users")
public class UsersController {
	@Autowired
	private UserService userservice;
	
	@GetMapping(value= {"", "/"})
	public  ResponseEntity<List<AppUser>> gettodo() {
		List<AppUser> res= userservice.findAll();
		return new ResponseEntity<List<AppUser>>(res, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value= {"", "/"})
	public ResponseEntity<AppUser> insertData(@Validated @RequestBody AppUser appuser) {
		System.out.println(appuser);
		//AppUser userr=new AppUser("raoufgf", "fahmi", "hh");
	
		AppUser user=new AppUser(appuser.getUsername(), appuser.getPassword(), appuser.getName());
		userservice.addUser(user);
		return new ResponseEntity<AppUser>(user, HttpStatus.CREATED);
	}
}
