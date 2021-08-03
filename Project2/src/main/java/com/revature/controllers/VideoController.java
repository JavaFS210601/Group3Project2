package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.revature.models.Favorite;
import com.revature.models.User;
import com.revature.models.Video;
import com.revature.models.Watch_Later;
import com.revature.services.VideoService;

@RestController
@SessionAttributes("user")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true", methods = RequestMethod.POST)
public class VideoController 
{
	private VideoService vs;
	
	@Autowired
	public VideoController(VideoService videoService)
	{
		super();
		this.vs = videoService;
	}
	
	@PostMapping("/addToWatch")
	public ResponseEntity addToWatch(@RequestBody Video videoId, HttpSession session, HttpServletRequest request)
	{
		List<User> user = new ArrayList<User>();
		user.add((User)session.getAttribute("user"));
		request.getCookies();
		//check if the user attribute is present...
		if(user != null)
		{
			//do stuff
			Watch_Later newItem = new Watch_Later(user, videoId.getId());
			vs.addToWatchList(newItem);
			
			return ResponseEntity.status(200).build();
		}
		
		return ResponseEntity.status(401).build();
	}
	
	@PostMapping("/addToFavorite")
	public ResponseEntity addToFavorite(@RequestBody Video videoId, HttpSession session, HttpServletRequest request)
	{
		/* currently users can have multiple entries that are the same, this should be changed later
		 * to check if a user already has the videoId associated with them. 
		 */
		List<User> user = new ArrayList<User>();
		user.add((User)session.getAttribute("user"));
		System.out.println("\"user\" session attribute: " + (User)session.getAttribute("user"));
//		System.out.println("cookies: " + request.getCookies().toString());
		//check if the user attribute is present...
		if(user != null)
		{
			//do stuff
			Favorite newItem = new Favorite(user, videoId.getId());
			vs.addToFavoriteList(newItem);
			
			return ResponseEntity.status(200).build();
		}
		
		return ResponseEntity.status(401).build();
	}
}
