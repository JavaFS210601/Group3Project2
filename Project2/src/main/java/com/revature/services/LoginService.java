package com.revature.services;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.revature.daos.UserDAO;
import com.revature.models.User;

@Service
@SessionAttributes("Session")
public class LoginService 
{
	private UserDAO userDao;
	@Autowired
	public LoginService(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}
	
	
	public boolean login(User user)
	{
		boolean authenticated = false;
		//query the database for the user
		Optional<User> rtnUser = userDao.findByUsername(user.getUsername());
		//check if the returned object is null, nothing
		if(rtnUser.isPresent())
		{
			//get the User Object from the Optional
			User phUser = rtnUser.get();
			//Compare the two passwords
			if(user.getPassword().compareTo(phUser.getPassword()) == 0)
			{
				//if the passwords are the same, return true
				authenticated = true;
			} 
		}
		return authenticated;
	}
	
	
//	public User login(User user)
//	{
//		boolean authenticated = false;
//		//query the database for the user
//		Optional<User> rtnUser = userDao.findByUsername(user.getUsername());
//		//check if the returned object is null, nothing
//		if(rtnUser.isPresent())
//		{
//			//get the User Object from the Optional
//			User phUser = rtnUser.get();
//			//Compare the two passwords
//			if(user.getPassword().compareTo(phUser.getPassword()) == 0)
//			{
//				//if the passwords are the same, return true
//				authenticated = true;
//				return phUser;
//			} 
//		}
//		return null;
//	}
}
