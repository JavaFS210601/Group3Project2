package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, methods = RequestMethod.POST.GET)
public class UserController 
{
	private UserService us;
	@Autowired
	public UserController(UserService userService) {
		super();
		this.us = userService;
	}
	
	@PostMapping("/accountCreation")
	public ResponseEntity userCreation(@RequestBody User user)
	{
		us.userCreation(user);
		
		return ResponseEntity.status(200).build();
	}
	
	@PostMapping("/accountUpdate")
	public ResponseEntity userUpdate(@RequestBody User user)
	{
		//we might need some kind of check to validate the user is in the database before trying to update their info
		if(us.userUpdate(user))
		{
			return ResponseEntity.status(200).build();
		}
		
		//406 Not Acceptable. User id was not correct
		return ResponseEntity.status(406).build();
	}
	@GetMapping("/testing")
	@ResponseBody
	public ResponseEntity testingSessions(@SessionAttribute("user") User user)
	{
		
		//return ResponseEntity.status(200).body(request.getAttributeNames());
		return ResponseEntity.status(200).body(user);
	}
}
