package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.revature.models.User;
import com.revature.services.LoginService;
import com.revature.services.UserService;

@RestController
@RequestMapping(value="/login")
@SessionAttributes("user")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true", methods = RequestMethod.POST)
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
			user = us.getFullUser(user);
			user.setPassword("");
			session.setAttribute("user", user);
			System.out.println("hello");
			return ResponseEntity.status(200).body(user);
		}
		return ResponseEntity.status(401).build();
	}
}
