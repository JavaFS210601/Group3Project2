package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.UserDAO;
import com.revature.models.User;
import com.revature.services.LoginService;

@RestController
@RequestMapping(value="/login")
public class LoginController 
{
	private LoginService ls;
	@Autowired
	public LoginController(LoginService LoginService) {
		super();
		this.ls = LoginService;
	}

	@PostMapping
	public ResponseEntity userLogin(@RequestBody User user)
	{
		//check if the user credentials are correct
		if(ls.login(user))
		{
			return ResponseEntity.status(200).build();
		}
		return ResponseEntity.status(401).build();
	}
}
