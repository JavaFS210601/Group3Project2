package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.LoginService;
import com.revature.services.UserService;

@RestController
@RequestMapping(value="/login")
@CrossOrigin
public class LoginController 
{
	
	
	private LoginService ls;
	private UserService us;
	@Autowired
	public LoginController(LoginService loginService, UserService userService) {
		super();
		this.ls = loginService;
		this.us = userService;
	}

	@PostMapping
	public ResponseEntity userLogin(@RequestBody User user, HttpSession session)
	{
				
		//check if the user credentials are correct
		if(ls.login(user))
		{
			//get back the full user object so we can access their data
			User userFromDB = us.getFullUser(user);
//			session.setAttribute("user_id", user.getId());
//			session.setAttribute("username", user.getUsername());
					
			return ResponseEntity.status(200).body(userFromDB);
		} 
		
		
		return ResponseEntity.status(401).build();
		
	} //this method now returns the info from the user in the database if the dao login method = true...
	//but this method does not change status to 401 if the return == null
	
	
//	@PostMapping
//	public User userLogin(@RequestBody User user, HttpSession session)
//	{
//		
//		
//		//check if the user credentials are correct
//		if(ls.login(user) != null)
//		{
//			//get back the full user object so we can access their data
//			User userFromDB = us.getFullUser(user);
//			session.setAttribute("user_id", user.getId());
//			session.setAttribute("username", user.getUsername());
//			ResponseEntity.status(200).build();
//			
//			return userFromDB;
//		} 
//		
////		ResponseEntity.status(401).build();
//		return null;
//		
//	} //this method now returns the info from the user in the database if the dao login method = true...
//	//but this method does not change status to 401 if the return == null
	
	
}